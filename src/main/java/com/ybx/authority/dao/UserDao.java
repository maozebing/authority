package com.ybx.authority.dao;

import com.ybx.authority.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByCodeAndPassword(String code,String password);

}
