/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.xiangliheart.modules.service.admin.dao.SysDeptMapper;
import com.xiangliheart.modules.service.admin.entity.SysStDept;
import com.xiangliheart.modules.service.admin.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xiangliheart.modules.frame.core.frame.persistence.pagehelper.PageRequest;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptMapper SysStDeptMapper;

    @Override
    public int save(SysStDept record) {
        if (record.getId() == null || record.getId() == 0) {
            return SysStDeptMapper.insertSelective(record);
        }
        return SysStDeptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int saveList(List<SysStDept> records) {
        return 0;
    }

    @Override
    public int delete(SysStDept record) {
        return SysStDeptMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysStDept> records) {
        for (SysStDept record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public int update(SysStDept record) {
        return 0;
    }

    @Override
    public SysStDept findById(Long id) {
        return SysStDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findPage(PageRequest pageRequest) {
        // return MybatisPageHelper.findPage(pageRequest, SysStDeptMapper);
        return null;
    }

    @Override
    public List<SysStDept> findTree() {
        List<SysStDept> SysStDepts = new ArrayList<>();
        List<SysStDept> depts = SysStDeptMapper.selectAll();
        for (SysStDept dept : depts) {
            if (dept.getParentId() == null || dept.getParentId() == 0) {
                dept.setLevel(0);
                SysStDepts.add(dept);
            }
        }
        findChildren(SysStDepts, depts);
        return SysStDepts;
    }

    private void findChildren(List<SysStDept> SysStDepts, List<SysStDept> depts) {
        for (SysStDept SysStDept : SysStDepts) {
            List<SysStDept> children = new ArrayList<>();
            for (SysStDept dept : depts) {
                if (SysStDept.getId() != null && SysStDept.getId().equals(dept.getParentId())) {
                    dept.setParentName(dept.getName());
                    dept.setLevel(SysStDept.getLevel() + 1);
                    children.add(dept);
                }
            }
            SysStDept.setChildren(children);
            findChildren(children, depts);
        }
    }

}
