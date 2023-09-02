/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.frame.persistence.pagehelper;

import com.github.pagehelper.PageInfo;

/**
 * PageUtils 分页工具类
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/9
 */
public class PageUtils {

    /**
     * getPageResult 将分页信息封装到统一的接口
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/7/9
     * @return: PageResult pageResult
     * @params: PageRequest, PageInfo<?>
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}