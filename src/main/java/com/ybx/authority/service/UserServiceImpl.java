package com.ybx.authority.service;

import com.ybx.authority.common.entity.Role;
import com.ybx.authority.common.entity.RoleUser;
import com.ybx.authority.common.entity.User;
import com.ybx.authority.common.viewentity.ViewRole;
import com.ybx.authority.common.viewentity.ViewUser;
import com.ybx.authority.dao.RoleDao;
import com.ybx.authority.dao.RoleUserDao;
import com.ybx.authority.dao.UserDao;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private RoleUserDao roleUserDao;
    @Resource
    private RoleDao roleDao;

    @Override
    public List<ViewUser> listUser() {
        List<User> userList=userDao.findAll();

        List<RoleUser> roleUserList=roleUserDao.findAll();

        List<Role> roleList=roleDao.findAll();

        Map<String, String> roleMap = roleList.stream().collect(Collectors.toMap(Role::getCode, Role::getName));

        List<ViewUser> viewUserList=new ArrayList<>();
        ViewUser viewUser;

        for (User user:userList) {
            viewUser=new ViewUser();
            BeanUtils.copyProperties(user,viewUser);

            List<RoleUser> result = roleUserList.stream()
                    .filter((RoleUser b) -> user.getCode().contains(b.getUserCode()))
                    .collect(Collectors.toList());

            List<ViewRole> viewRoleList=new ArrayList<>();
            ViewRole viewRole;
            for (RoleUser roleUser:result) {
                viewRole=new ViewRole();
                viewRole.setCode(roleUser.getRoleCode());
                viewRole.setName(roleMap.get(roleUser.getRoleCode()));
                viewRoleList.add(viewRole);
            }
            viewUser.setRoles(viewRoleList);
            viewUserList.add(viewUser);
        }

        return viewUserList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addUser(ViewUser viewUser) {
        User user=new User();
        BeanUtils.copyProperties(viewUser,user);
        Date date=new Date();
        user.setCreate(date);
        user.setModified(date);

        List<RoleUser> roleUserList=new ArrayList<>();
        RoleUser roleUser;
        for (ViewRole viewRole:viewUser.getRoles()) {
            roleUser=new RoleUser();
            roleUser.setUserCode(viewUser.getCode());
            roleUser.setRoleCode(viewRole.getCode());
            roleUserList.add(roleUser);
        }

        userDao.save(user);
        roleUserDao.saveAll(roleUserList);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUser(ViewUser viewUser) {
        User user=new User();
        BeanUtils.copyProperties(viewUser,user);
        Date date=new Date();
        user.setCreate(date);
        user.setModified(date);

        List<RoleUser> roleUserList=new ArrayList<>();
        RoleUser roleUser;
        for (ViewRole viewRole:viewUser.getRoles()) {
            roleUser=new RoleUser();
            roleUser.setUserCode(viewUser.getCode());
            roleUser.setRoleCode(viewRole.getCode());
            roleUserList.add(roleUser);
        }

        userDao.save(user);

        roleUserDao.deleteByUserCode(viewUser.getCode());
        roleUserDao.saveAll(roleUserList);
    }
}
