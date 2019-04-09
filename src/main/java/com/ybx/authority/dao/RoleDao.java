package com.ybx.authority.dao;

import com.ybx.authority.common.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
