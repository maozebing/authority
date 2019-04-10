package com.ybx.authority.service;

import com.ybx.authority.common.viewentity.ViewRole;

import java.util.List;

public interface RoleService {

    List<ViewRole> listRole();

    void addRole(ViewRole viewRole);

    void updateRole(ViewRole viewRole);

}
