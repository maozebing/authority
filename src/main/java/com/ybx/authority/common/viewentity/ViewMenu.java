package com.ybx.authority.common.viewentity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViewMenu {
    private long id;
    private String code;
    private String name;
    private String icon;
    private boolean leaf;
    private String parent;
    private String describe;
    private String[] actions;
    private List<ViewAction> actionsData;
    private boolean deleted;
}
