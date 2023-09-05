package com.xiangliheart.modules.service.admin.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.xiangliheart.modules.service.admin.dao.SysCustomerUserMapper;
import com.xiangliheart.modules.service.admin.entity.SysUser;
import com.xiangliheart.modules.service.admin.service.SysCustomerUserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xiangliheart.modules.frame.core.frame.persistence.pagehelper.PageRequest;

import tk.mybatis.mapper.entity.Example;

/**
 * SysAmCustomerUserServiceImpl
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/10
 */
@Service
public class SysCustomerUserServiceImpl implements SysCustomerUserService {
    @Autowired
    SysCustomerUserMapper sysAmCustomerUserMapper;

    @Override
    public int save(SysUser record) {
        return sysAmCustomerUserMapper.insert(record);
    }

    @Override
    public int saveList(List<SysUser> records) {
        return sysAmCustomerUserMapper.insertList(records);
    }

    @Override
    public int delete(SysUser record) {
        return sysAmCustomerUserMapper.delete(record);
    }

    @Override
    public int delete(List<SysUser> records) {
        return 0;
    }

    @Override
    public int update(SysUser record) {
        return sysAmCustomerUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public SysUser findById(Long id) {
        return sysAmCustomerUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findPage(PageRequest pageRequest) {
        RowBounds rowBounds = new RowBounds(pageRequest.getPageNum(), pageRequest.getPageSize());
        Example example = new Example(SysUser.class);
        List<SysUser> sysAmCustomerUsers = sysAmCustomerUserMapper.selectByExampleAndRowBounds(example, rowBounds);
        return new PageInfo(sysAmCustomerUsers);
    }

    @Override
    public SysUser findByCustomerUserName(String name) {
        SysUser customerUser = new SysUser();
        customerUser.setId(1L);
        customerUser.setName(name);
        String password = new BCryptPasswordEncoder().encode("123");
        customerUser.setPassword(password);
        return customerUser;
    }

    @Override
    public Set<String> findPermissions(String customerUserName) {
        Set<String> permissions = new HashSet<>();
        permissions.add("sys:user:view");
        permissions.add("sys:user:add");
        permissions.add("sys:user:edit");
        permissions.add("sys:user:delete");
        return permissions;
    }
}
