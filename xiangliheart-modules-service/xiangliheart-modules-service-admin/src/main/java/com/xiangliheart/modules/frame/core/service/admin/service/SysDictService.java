/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.service.admin.service;

import java.util.List;

import com.xiangliheart.modules.frame.core.frame.persistence.service.CurdService;
import com.xiangliheart.modules.frame.core.service.admin.entity.SysDict;

/**
 * /** SysDictService 字典管理
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/11/27
 */
public interface SysDictService extends CurdService<SysDict> {

    List<SysDict> findByLable(String lable);
}
