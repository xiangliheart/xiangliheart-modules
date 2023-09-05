/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.service.impl;

import java.util.List;

import com.xiangliheart.modules.service.admin.dao.SysLogMapper;
import com.xiangliheart.modules.service.admin.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xiangliheart.modules.frame.core.frame.persistence.pagehelper.PageRequest;
import com.xiangliheart.modules.service.admin.entity.SysLog;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysCmLogMapper;

    @Override
    public int save(SysLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysCmLogMapper.insertSelective(record);
        }
        return sysCmLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int saveList(List<SysLog> records) {
        return 0;
    }

    @Override
    public int delete(SysLog record) {
        return sysCmLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        for (SysLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public int update(SysLog record) {
        return 0;
    }

    @Override
    public SysLog findById(Long id) {
        return sysCmLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findPage(PageRequest pageRequest) {
        /*Object label = pageRequest.getParam("userName");
        if(label != null) {
        	return MybatisPageHelper.findPage(pageRequest, SysCmLogMapper, "findPageByUserName", label);
        }
        return MybatisPageHelper.findPage(pageRequest, SysCmLogMapper);*/
        return null;
    }

}
