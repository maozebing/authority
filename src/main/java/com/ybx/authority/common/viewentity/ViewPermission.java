package com.ybx.authority.common.viewentity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViewPermission {

    private String permissionId;
    private String permissionName;
    private String[] actions;
    private List<ViewAction> actionsData;

}
