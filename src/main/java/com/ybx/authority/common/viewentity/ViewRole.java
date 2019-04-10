package com.ybx.authority.common.viewentity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViewRole {

    private long id;
    private String code;
    private String name;
    private String describes;
    private boolean deleted;
    private List<ViewPermission> permissions;

}
