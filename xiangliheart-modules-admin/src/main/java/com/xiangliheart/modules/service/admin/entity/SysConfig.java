/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

import com.xiangliheart.modules.frame.core.frame.persistence.entity.BaseEntity;

import lombok.Data;

@Data
@Table(name = "sys_config")
public class SysConfig extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "value")
    private String value;
    @Column(name = "label")
    private String label;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "sort")
    private Long sort;
    @Column(name = "remarks")
    private String remarks;
}