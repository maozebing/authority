package com.ybx.authority.common.viewentity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViewLoginUserPermissions {
    private String code;
    private String name;
    private String[] roles;
    private List<ViewPermission> permissions;
}
