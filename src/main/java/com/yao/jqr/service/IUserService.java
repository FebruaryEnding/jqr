package com.yao.jqr.service;

import com.yao.jqr.constant.DataStatus;
import com.yao.jqr.dto.query.UserQuery;
import com.yao.jqr.dto.request.UserRequestDTO;
import com.yao.jqr.dto.response.UserResponseDTO;
import com.yao.jqr.dto.result.PageResult;
import com.yao.jqr.entity.UserEntity;
import org.springframework.data.domain.Page;

public interface IUserService {

    void regest(UserRequestDTO userRequestDTO) throws Exception;

    UserEntity save(UserEntity userEntity);

    UserResponseDTO findById(String id);

    UserEntity findByIdAndStatus(String id, DataStatus dataStatus);

    PageResult pageQuery(UserQuery query);

    UserEntity findByPhone(String phone);

    UserEntity findByName(String userName);
}
