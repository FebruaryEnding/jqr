package com.yao.jqr.service.Impl;

import com.yao.jqr.constant.DataStatus;
import com.yao.jqr.dto.query.UserQuery;
import com.yao.jqr.dto.request.UserRequestDTO;
import com.yao.jqr.dto.response.UserResponseDTO;
import com.yao.jqr.dto.result.PageResult;
import com.yao.jqr.entity.UserEntity;
import com.yao.jqr.entity.repository.UserEntityRepository;
import com.yao.jqr.service.IUserService;
import com.yao.jqr.util.BeanCopyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    private String generateSalt() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 6);
    }


    @Override
    public void regest(UserRequestDTO userRequestDTO) {
        UserEntity entity = BeanCopyUtils.copy(userRequestDTO, UserEntity.class);
        String salt = generateSalt();
        entity.setPassword(DigestUtils.md5Hex(salt + entity.getPassword()));
        entity.setId(null);
        save(entity);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }

    @Override
    public UserResponseDTO findById(String id) {
        UserEntity userEntity = findByIdAndStatus(id, DataStatus.NORMAL);
        return BeanCopyUtils.copy(userEntity, UserResponseDTO.class);
    }

    @Override
    public UserEntity findByIdAndStatus(String id, DataStatus dataStatus) {
        return userEntityRepository.findByIdAndStatus(id, dataStatus.getStatus());
    }

    @Override
    public PageResult pageQuery(UserQuery query) {
        Page<UserEntity> page = userEntityRepository.findAll(new Specification<UserEntity>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("status"),DataStatus.NORMAL.getStatus()));
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        }, new PageRequest(query.getPage(), query.getPageSize()));
        List<UserEntity> content = page.getContent();
        List<UserResponseDTO> list = BeanCopyUtils.copyList(content, UserResponseDTO.class);
        return PageResult.newInstace(list, page.getTotalPages(), page.getTotalElements(), page.getNumber());
    }

    @Override
    public UserEntity findByPhone(String phone) {
        return userEntityRepository.findByPhone(phone);
    }

}
