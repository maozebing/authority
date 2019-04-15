package com.ybx.authority.service;

import com.ybx.authority.common.viewentity.ViewLoginUser;
import com.ybx.authority.common.viewentity.ViewLoginUserPermissions;

public interface PermissionService {
    ViewLoginUser login(String code, String passward) throws Exception;

    ViewLoginUserPermissions getUserPermissions(String code);
}
