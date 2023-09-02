/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.frame.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * IOUtils IO相关工具类
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/20
 */
public class IOUtils {

    /**
     * closeQuietly 关闭对象，连接
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/7/20
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
        }
    }
}
