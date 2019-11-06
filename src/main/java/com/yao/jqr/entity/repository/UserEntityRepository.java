package com.yao.jqr.entity.repository;

import com.yao.jqr.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserEntityRepository extends JpaSpecificationExecutor<UserEntity> ,JpaRepository<UserEntity,String> {

    UserEntity findByIdAndStatus(String id, Integer status);

    UserEntity findByPhone(String phone);

    UserEntity findByName(String userName);
}
