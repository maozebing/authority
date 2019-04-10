package com.ybx.authority.service;

import com.ybx.authority.common.viewentity.ViewUser;

import java.util.List;

public interface UserService {

    List<ViewUser> listUser();

    void addUser(ViewUser viewUser);

    void updateUser(ViewUser viewUser);

}
