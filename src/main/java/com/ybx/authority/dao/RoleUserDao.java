package com.ybx.authority.dao;

import com.ybx.authority.common.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUserDao extends JpaRepository<RoleUser, Long> {
}
