package com.ybx.authority.common.viewentity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViewUser {

    private long id;
    private String code;
    private String name;
    private String password;
    private boolean man;
    private String phone;
    private String email;
    private boolean deleted;
    private List<ViewRole> roles;

}
