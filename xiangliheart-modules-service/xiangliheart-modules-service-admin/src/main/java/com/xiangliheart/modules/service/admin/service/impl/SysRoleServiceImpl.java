/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.service.impl;

import java.util.List;

import com.xiangliheart.modules.service.admin.constant.SysConstants;
import com.xiangliheart.modules.service.admin.dao.SysMenuMapper;
import com.xiangliheart.modules.service.admin.dao.SysRoleMapper;
import com.xiangliheart.modules.service.admin.dao.SysRoleMenuMapper;
import com.xiangliheart.modules.service.admin.entity.SysRoleMenu;
import com.xiangliheart.modules.service.admin.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.xiangliheart.modules.frame.core.frame.persistence.pagehelper.PageRequest;
import com.xiangliheart.modules.service.admin.entity.SysMenu;
import com.xiangliheart.modules.service.admin.entity.SysRole;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysAhRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysAhRoleMenuMapper;
    @Autowired
    private SysMenuMapper sysAhMenuMapper;

    @Override
    public int save(SysRole record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysAhRoleMapper.insertSelective(record);
        }
        return sysAhRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int saveList(List<SysRole> records) {
        return 0;
    }

    @Override
    public int delete(SysRole record) {
        return sysAhRoleMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysRole> records) {
        for (SysRole record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public int update(SysRole record) {
        return 0;
    }

    @Override
    public SysRole findById(Long id) {
        return sysAhRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findPage(PageRequest pageRequest) {
        /*Object label = pageRequest.getParam("name");
        if(label != null) {
        	return MybatisPageHelper.findPage(pageRequest, SysAhRoleMapper, "findPageByName", label);
        }
        return MybatisPageHelper.findPage(pageRequest, SysAhRoleMapper);*/
        return null;
    }

    @Override
    public List<SysRole> findAll() {
        return sysAhRoleMapper.selectAll();
    }

    public SysRoleMapper getSysAhRoleMapper() {
        return sysAhRoleMapper;
    }

    public void setSysAhRoleMapper(SysRoleMapper SysAhRoleMapper) {
        this.sysAhRoleMapper = SysAhRoleMapper;
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole SysAhRole = sysAhRoleMapper.selectByPrimaryKey(roleId);
        if (SysConstants.ADMIN.equalsIgnoreCase(SysAhRole.getName())) {
            // 如果是超级管理员，返回全部
            return sysAhMenuMapper.selectAll();
        }
        // return sysAhMenuMapper.findRoleMenus(roleId);
        return null;
    }

    @Transactional
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if (records == null || records.isEmpty()) {
            return 1;
        }
        String roleId = records.get(0).getRoleId();
        sysAhRoleMenuMapper.deleteByPrimaryKey(roleId);
        for (SysRoleMenu record : records) {
            sysAhRoleMenuMapper.insertSelective(record);
        }
        return 1;
    }

    @Override
    public List<SysRole> findByName(String name) {
        // return sysAhRoleMapper.findByName(name);
        return null;
    }

}
