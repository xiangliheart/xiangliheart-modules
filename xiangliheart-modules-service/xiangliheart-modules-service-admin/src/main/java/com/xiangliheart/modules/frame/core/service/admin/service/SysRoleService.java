/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.service.admin.service;

import java.util.List;

import com.xiangliheart.modules.frame.core.frame.persistence.service.CurdService;
import com.xiangliheart.modules.frame.core.service.admin.entity.SysMenu;
import com.xiangliheart.modules.frame.core.service.admin.entity.SysRole;
import com.xiangliheart.modules.frame.core.service.admin.entity.SysRoleMenu;

/**
 * SysRoleService 角色管理
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/11/27
 */
public interface SysRoleService extends CurdService<SysRole> {

    List<SysRole> findAll();

    List<SysMenu> findRoleMenus(Long roleId);

    int saveRoleMenus(List<SysRoleMenu> records);

    List<SysRole> findByName(String name);
}
