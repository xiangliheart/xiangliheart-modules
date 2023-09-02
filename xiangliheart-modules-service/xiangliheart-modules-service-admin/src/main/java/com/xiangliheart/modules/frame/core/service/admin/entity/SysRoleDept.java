/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.service.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

import com.xiangliheart.modules.frame.core.frame.persistence.entity.BaseEntity;

import lombok.Data;

@Data
@Table(name = "sys_role_dept")
public class SysRoleDept extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "dept_id")
    private Long deptId;
}