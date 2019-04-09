package com.ybx.authority.service;


import cn.hutool.core.convert.Convert;
import com.ybx.authority.common.entity.Menu;
import com.ybx.authority.common.utils.EnumClass;
import com.ybx.authority.common.viewentity.ViewAction;
import com.ybx.authority.common.viewentity.ViewMenu;
import com.ybx.authority.dao.MenuDao;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;

    @Override
    public List<ViewMenu> listMenu() {
        List<Menu> list = menuDao.findAll();

        List<ViewMenu> viewMenuList = new ArrayList<>();

        ViewMenu viewMenu;
        for (Menu menu : list) {
            viewMenu = new ViewMenu();
            BeanUtils.copyProperties(menu, viewMenu);
            String[] actionArr = menu.getActions().split(",");
            if (menu.isLeaf() && actionArr.length > 0) {
                List<ViewAction> viewActions = new ArrayList<>();
                ViewAction viewAction;
                for (String action : actionArr) {
                    viewAction = new ViewAction();
                    viewAction.setValue(action);
                    viewAction.setLabel(EnumClass.ActionType.getActionType(action).name());
                    viewActions.add(viewAction);
                }
                viewMenu.setActions(actionArr);
                viewMenu.setActionsData(viewActions);
            }
            viewMenuList.add(viewMenu);
        }
        return viewMenuList;
    }
}
