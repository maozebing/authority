package com.ybx.authority.dao;

import com.ybx.authority.common.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleMenuDao extends JpaRepository<RoleMenu, Long> {

    void deleteByRoleCode(String roleCode);

}
