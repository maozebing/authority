package com.ybx.authority.service;

import cn.hutool.core.util.ArrayUtil;
import com.ybx.authority.common.entity.Menu;
import com.ybx.authority.common.entity.Role;
import com.ybx.authority.common.entity.RoleMenu;
import com.ybx.authority.common.utils.EnumClass;
import com.ybx.authority.common.viewentity.ViewAction;
import com.ybx.authority.common.viewentity.ViewPermission;
import com.ybx.authority.common.viewentity.ViewRole;
import com.ybx.authority.dao.MenuDao;
import com.ybx.authority.dao.RoleDao;
import com.ybx.authority.dao.RoleMenuDao;
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
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;
    @Resource
    private RoleMenuDao roleMenuDao;
    @Resource
    private MenuDao menuDao;

    @Override
    public List<ViewRole> listRole() {
        List<Role> roleList = roleDao.findAll();

        List<RoleMenu> roleMenuList = roleMenuDao.findAll();

        List<Menu> menuList = menuDao.findAll();

        Map<String, String> menuMap = menuList.stream().collect(Collectors.toMap(Menu::getCode, Menu::getName));

        List<ViewRole> viewRoleList = new ArrayList<>();

        ViewRole viewRole;

        for (Role role : roleList) {
            viewRole = new ViewRole();
            BeanUtils.copyProperties(role, viewRole);

            List<RoleMenu> result = roleMenuList.stream()
                    .filter((RoleMenu b) -> role.getCode().contains(b.getRoleCode()))
                    .collect(Collectors.toList());

            List<ViewPermission> viewPermissionList = new ArrayList<>();
            ViewPermission viewPermission;

            for (RoleMenu roleMenu : result) {
                viewPermission = new ViewPermission();
                viewPermission.setPermissionId(roleMenu.getMenuCode());
                viewPermission.setPermissionName(menuMap.get(roleMenu.getMenuCode()));

                String[] actionArr = roleMenu.getMenuActions().split(",");
                if (actionArr.length > 0) {
                    List<ViewAction> viewActions = new ArrayList<>();
                    ViewAction viewAction;
                    for (String action : actionArr) {
                        viewAction = new ViewAction();
                        viewAction.setValue(action);
                        viewAction.setLabel(EnumClass.ActionType.getActionType(action).name());
                        viewActions.add(viewAction);
                    }
                    viewPermission.setActions(actionArr);
                    viewPermission.setActionsData(viewActions);
                }

                viewPermissionList.add(viewPermission);
            }
            viewRole.setPermissions(viewPermissionList);
            viewRoleList.add(viewRole);
        }
        return viewRoleList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addRole(ViewRole viewRole) {
        Role role = new Role();
        role.setId(viewRole.getId());
        role.setCode(viewRole.getCode());
        role.setName(viewRole.getName());
        role.setDeleted(viewRole.isDeleted());
        role.setDescribes(viewRole.getDescribes());
        Date date = new Date();
        role.setCreate(date);
        role.setModified(date);

        List<RoleMenu> roleMenuList = new ArrayList<>();
        RoleMenu roleMenu;
        for (ViewPermission permission : viewRole.getPermissions()) {
            roleMenu = new RoleMenu();
            roleMenu.setRoleCode(viewRole.getCode());
            roleMenu.setMenuCode(permission.getPermissionId());
            roleMenu.setMenuActions(ArrayUtil.join(permission.getActions(),","));
            roleMenuList.add(roleMenu);
        }

        roleDao.save(role);
        roleMenuDao.saveAll(roleMenuList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateRole(ViewRole viewRole) {
        Role role = new Role();
        role.setId(viewRole.getId());
        role.setCode(viewRole.getCode());
        role.setName(viewRole.getName());
        role.setDeleted(viewRole.isDeleted());
        role.setDescribes(viewRole.getDescribes());
        role.setModified(new Date());

        List<RoleMenu> roleMenuList = new ArrayList<>();
        RoleMenu roleMenu;
        for (ViewPermission permission : viewRole.getPermissions()) {
            roleMenu = new RoleMenu();
            roleMenu.setRoleCode(viewRole.getCode());
            roleMenu.setMenuCode(permission.getPermissionId());
            roleMenu.setMenuActions(ArrayUtil.join(permission.getActions(),","));
            roleMenuList.add(roleMenu);
        }

        roleDao.save(role);

        roleMenuDao.deleteByRoleCode(viewRole.getCode());
        roleMenuDao.saveAll(roleMenuList);
    }


}
