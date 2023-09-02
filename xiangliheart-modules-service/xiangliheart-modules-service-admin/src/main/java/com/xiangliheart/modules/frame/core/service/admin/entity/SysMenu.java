/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.service.admin.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;

import com.xiangliheart.modules.frame.core.frame.persistence.entity.BaseEntity;

import lombok.Data;

@Data
@Table(name = "sys_menu")
public class SysMenu extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "name")
    private String name;
    @Column(name = "parent_id")
    private Long parentId;
    @Column(name = "url")
    private String url;
    @Column(name = "perms")
    private String perms;
    @Column(name = "type")
    private Integer type;
    @Column(name = "icon")
    private String icon;
    @Column(name = "order_num")
    private Integer orderNum;
    // 非数据库字段
    private String parentName;
    // 非数据库字段
    private Integer level;
    // 非数据库字段
    private List<SysMenu> children;
}