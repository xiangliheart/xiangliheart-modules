/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.frame.persistence.pagehelper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * PageRequest 分页请求
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/9
 */
@Data
@ApiModel
public class PageRequest {
    @ApiModelProperty(value = "页码")
    private int pageNum;

    @ApiModelProperty(value = "每页条数")
    private int pageSize;
}
