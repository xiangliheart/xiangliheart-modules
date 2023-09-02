/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.frame.persistence.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * CommonBaseMapper
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/9/15
 */
public interface CommonBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {}
