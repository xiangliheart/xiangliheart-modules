/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.service.impl;

import java.util.List;

import com.xiangliheart.modules.service.admin.dao.SysDictMapper;
import com.xiangliheart.modules.service.admin.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xiangliheart.modules.frame.core.frame.persistence.pagehelper.PageRequest;
import com.xiangliheart.modules.service.admin.entity.SysDict;

@Service
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper sysCmDictMapper;

    @Override
    public int save(SysDict record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysCmDictMapper.insertSelective(record);
        }
        return sysCmDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int saveList(List<SysDict> records) {
        return 0;
    }

    @Override
    public int delete(SysDict record) {
        return sysCmDictMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDict> records) {
        for (SysDict record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public int update(SysDict record) {
        return 0;
    }

    @Override
    public SysDict findById(Long id) {
        return sysCmDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findPage(PageRequest pageRequest) {
        /*Object label = pageRequest.getParam("label");
        if(label != null) {
        	return MybatisPageHelper.findPage(pageRequest, SysCmDictMapper, "findPageByLabel", label);
        }
        return MybatisPageHelper.findPage(pageRequest, SysCmDictMapper);*/
        return null;
    }

    @Override
    public List<SysDict> findByLable(String lable) {
        // return sysCmDictMapper.findByLable(lable);
        return null;
    }

}
