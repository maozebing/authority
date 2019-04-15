package com.ybx.authority.service;

import com.ybx.authority.common.entity.User;
import com.ybx.authority.common.exception.LoginException;
import com.ybx.authority.common.utils.TokenUtil;
import com.ybx.authority.common.viewentity.ViewLoginUser;
import com.ybx.authority.common.viewentity.ViewLoginUserPermissions;
import com.ybx.authority.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private UserDao userDao;

    @Override
    public ViewLoginUser login(String code, String password) throws Exception {
        User user = userDao.findByCodeAndPassword(code, password);
        if (user != null) {
            ViewLoginUser viewLoginUser = new ViewLoginUser();
            viewLoginUser.setCode(user.getCode());
            viewLoginUser.setName(user.getName());
            viewLoginUser.setToken(TokenUtil.createToken(user.getCode()));
            return viewLoginUser;
        } else {
            throw new LoginException("用户名或密码错误！");
        }
    }

    @Override
    public ViewLoginUserPermissions getUserPermissions(String code) {



        return null;
    }
}
