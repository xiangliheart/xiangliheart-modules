/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.service.impl;

import java.util.List;

import com.xiangliheart.modules.service.admin.dao.SysCustomerMapper;
import com.xiangliheart.modules.service.admin.service.SysCustomerService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xiangliheart.modules.frame.core.frame.persistence.pagehelper.PageRequest;
import com.xiangliheart.modules.service.admin.entity.SysCustomer;

import tk.mybatis.mapper.entity.Example;

/**
 * SysAmCustomerServiceImpl
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/2
 */
@Service
public class SysCustomerServiceImpl implements SysCustomerService {

    @Autowired
    SysCustomerMapper sysAmCustomerMapper;

    @Override
    public int save(SysCustomer record) {
        return sysAmCustomerMapper.insert(record);
    }

    @Override
    public int saveList(List<SysCustomer> records) {
        return sysAmCustomerMapper.insertList(records);
    }

    @Override
    public int delete(SysCustomer record) {
        return sysAmCustomerMapper.delete(record);
    }

    @Override
    public int delete(List<SysCustomer> records) {
        return 0;
    }

    @Override
    public int update(SysCustomer record) {
        return sysAmCustomerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public SysCustomer findById(Long id) {
        return sysAmCustomerMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findPage(PageRequest pageRequest) {
        RowBounds rowBounds = new RowBounds(pageRequest.getPageNum(), pageRequest.getPageSize());
        Example example = new Example(SysCustomer.class);
        List<SysCustomer> sysAmCustomers = sysAmCustomerMapper.selectByExampleAndRowBounds(example, rowBounds);
        return new PageInfo(sysAmCustomers);
    }
}
