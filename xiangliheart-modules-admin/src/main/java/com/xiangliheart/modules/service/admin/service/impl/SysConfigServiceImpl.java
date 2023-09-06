/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.service.impl;

import java.util.List;

import com.xiangliheart.modules.service.admin.dao.SysConfigMapper;
import com.xiangliheart.modules.service.admin.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xiangliheart.modules.frame.core.frame.persistence.pagehelper.PageRequest;
import com.xiangliheart.modules.service.admin.entity.SysConfig;

@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigMapper SysCmConfigMapper;

    @Override
    public int save(SysConfig record) {
        if (record.getId() == null || record.getId() == 0) {
            return SysCmConfigMapper.insertSelective(record);
        }
        return SysCmConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int saveList(List<SysConfig> records) {
        return 0;
    }

    @Override
    public int delete(SysConfig record) {
        return SysCmConfigMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysConfig> records) {
        return 0;
    }

    @Override
    public int update(SysConfig record) {
        return 0;
    }

    @Override
    public SysConfig findById(Long id) {
        return null;
    }

    @Override
    public PageInfo findPage(PageRequest pageRequest) {
        return null;
    }

    @Override
    public List<SysConfig> findByLable(String lable) {
        return null;
    }
}
