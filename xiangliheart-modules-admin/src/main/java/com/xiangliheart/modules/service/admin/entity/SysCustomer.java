/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

import com.xiangliheart.modules.frame.core.frame.persistence.entity.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Table(name = "sys_customer")
public class SysCustomer extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "region_code")
    @ApiModelProperty(value = "区域代码")
    private String regionCode;
    @Column(name = "name")
    @ApiModelProperty(value = "客户名称")
    private String name;
    @Column(name = "status")
    @ApiModelProperty(value = "客户状态")
    private Integer status;
}