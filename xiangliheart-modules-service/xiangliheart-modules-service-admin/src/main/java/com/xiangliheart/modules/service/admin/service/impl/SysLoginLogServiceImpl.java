/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.service.impl;

import java.util.List;

import com.xiangliheart.modules.service.admin.dao.SysLoginLogMapper;
import com.xiangliheart.modules.service.admin.service.SysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xiangliheart.modules.frame.core.frame.persistence.pagehelper.PageRequest;
import com.xiangliheart.modules.service.admin.entity.SysLoginLog;

@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {
    @Autowired
    private SysLoginLogMapper sysAhLoginLogMapper;

    @Override
    public int save(SysLoginLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysAhLoginLogMapper.insertSelective(record);
        }
        return sysAhLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int saveList(List<SysLoginLog> records) {
        return 0;
    }

    @Override
    public int delete(SysLoginLog record) {
        return sysAhLoginLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLoginLog> records) {
        for (SysLoginLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public int update(SysLoginLog record) {
        return 0;
    }

    @Override
    public SysLoginLog findById(Long id) {
        return sysAhLoginLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findPage(PageRequest pageRequest) {
        /*Object userName = pageRequest.getParam("userName");
        if(userName != null) {
        	return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findPageByUserName", userName);
        }
        Object status = pageRequest.getParam("status");
        if(status != null) {
        	return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findPageByStatus", status);
        }
        return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper);*/
        return null;
    }

}
