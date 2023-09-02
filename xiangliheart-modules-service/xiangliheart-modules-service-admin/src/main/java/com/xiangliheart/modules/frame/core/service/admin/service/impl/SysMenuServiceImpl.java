/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.service.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.xiangliheart.modules.frame.core.service.admin.constant.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xiangliheart.modules.frame.core.frame.persistence.pagehelper.PageRequest;
import com.xiangliheart.modules.frame.core.service.admin.dao.SysMenuMapper;
import com.xiangliheart.modules.frame.core.service.admin.entity.SysMenu;
import com.xiangliheart.modules.frame.core.service.admin.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper SysAhMenuMapper;

    @Override
    public int save(SysMenu record) {
        if (record.getId() == null || record.getId() == 0) {
            return SysAhMenuMapper.insertSelective(record);
        }
        if (record.getParentId() == null) {
            record.setParentId(0L);
        }
        return SysAhMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int saveList(List<SysMenu> records) {
        return 0;
    }

    @Override
    public int delete(SysMenu record) {
        return SysAhMenuMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysMenu> records) {
        for (SysMenu record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public int update(SysMenu record) {
        return 0;
    }

    @Override
    public SysMenu findById(Long id) {
        return SysAhMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findPage(PageRequest pageRequest) {
        // return MybatisPageHelper.findPage(pageRequest, SysAhMenuMapper);
        return null;
    }

    @Override
    public List<SysMenu> findTree(String userName, int menuType) {
        List<SysMenu> SysAhMenus = new ArrayList<>();
        List<SysMenu> menus = findByUser(userName);
        for (SysMenu menu : menus) {
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                menu.setLevel(0);
                if (!exists(SysAhMenus, menu)) {
                    SysAhMenus.add(menu);
                }
            }
        }
        SysAhMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(SysAhMenus, menus, menuType);
        return SysAhMenus;
    }

    @Override
    public List<SysMenu> findByUser(String userName) {
        if (userName == null || "".equals(userName) || SysConstants.ADMIN.equalsIgnoreCase(userName)) {
            return SysAhMenuMapper.selectAll();
        }
        // return SysAhMenuMapper.findByUserName(userName);
        return null;
    }

    private void findChildren(List<SysMenu> SysAhMenus, List<SysMenu> menus, int menuType) {
        for (SysMenu SysAhMenu : SysAhMenus) {
            List<SysMenu> children = new ArrayList<>();
            for (SysMenu menu : menus) {
                if (menuType == 1 && menu.getType() == 2) {
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue;
                }
                if (SysAhMenu.getId() != null && SysAhMenu.getId().equals(menu.getParentId())) {
                    menu.setParentName(SysAhMenu.getName());
                    menu.setLevel(SysAhMenu.getLevel() + 1);
                    if (!exists(children, menu)) {
                        children.add(menu);
                    }
                }
            }
            SysAhMenu.setChildren(children);
            children.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
            findChildren(children, menus, menuType);
        }
    }

    private boolean exists(List<SysMenu> SysAhMenus, SysMenu SysAhMenu) {
        boolean exist = false;
        for (SysMenu menu : SysAhMenus) {
            if (menu.getId().equals(SysAhMenu.getId())) {
                exist = true;
            }
        }
        return exist;
    }

}
