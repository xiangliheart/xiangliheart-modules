/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.frame.persistence.pagehelper;

import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * PageResult 分页返回结果
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/9
 */
@Data
@ApiModel
public class PageResult {
    private int pageNum;

    private int pageSize;

    private long totalSize;

    private int totalPages;

    private List<?> content;
}
