/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.service.admin.service;

import java.util.List;

import com.xiangliheart.modules.frame.core.frame.persistence.service.CurdService;
import com.xiangliheart.modules.frame.core.service.admin.entity.SysStDept;

/**
 * SysDeptService 机构管理
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/11/27
 */
public interface SysDeptService extends CurdService<SysStDept> {

    List<SysStDept> findTree();
}
