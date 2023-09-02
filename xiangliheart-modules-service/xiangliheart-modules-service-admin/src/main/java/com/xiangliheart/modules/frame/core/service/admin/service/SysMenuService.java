/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.service.admin.service;

import java.util.List;

import com.xiangliheart.modules.frame.core.frame.persistence.service.CurdService;
import com.xiangliheart.modules.frame.core.service.admin.entity.SysMenu;

/**
 * SysMenuService 菜单管理
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/11/27
 */
public interface SysMenuService extends CurdService<SysMenu> {

    SysMenu findById(Long id);

    /**
     * findTree 查询菜单树,用户ID和用户名为空则查询全部
     * 
     * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/11/27
     */
    List<SysMenu> findTree(String userName, int menuType);

    /**
     * findByUser 根据用户名查找菜单列表
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/11/27
     */
    List<SysMenu> findByUser(String userName);
}
