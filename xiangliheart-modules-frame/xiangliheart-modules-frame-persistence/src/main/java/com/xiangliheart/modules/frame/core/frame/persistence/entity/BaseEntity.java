package com.xiangliheart.modules.frame.core.frame.persistence.entity;

import java.util.Date;

import javax.persistence.Column;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * BaseEntity 基础模型
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/10
 */
@Data
public class BaseEntity {
    @Column(name = "id")
    @ApiModelProperty(value = "唯一标识id")
    private Long id;
    @ApiModelProperty(value = "创建人")
    @Column(name = "create_by")
    private String createBy;
    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;
    @ApiModelProperty(value = "最后修改人")
    @Column(name = "last_update_by")
    private String lastUpdateBy;
    @ApiModelProperty(value = "最后修改时间")
    @Column(name = "last_update_time")
    private Date lastUpdateTime;
    @ApiModelProperty(value = "删除标识")
    @Column(name = "del_flag")
    private Byte delFlag;
}
