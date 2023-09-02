package com.xiangliheart.modules.frame.core.frame.security.utils;

import java.util.UUID;

/**
 * PasswordUtils 密码工具类
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/10
 */
public class PasswordUtils {

    /**
     * matches 匹配密码
     *
     * @param salt 盐、rawPass 明文、encPass 密文
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/14
     */
    public static boolean matches(String salt, String rawPass, String encPass) {
        return new PasswordEncoder(salt).matches(encPass, rawPass);
    }

    /**
     * encode 明文密码加密
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/14
     */
    public static String encode(String rawPass, String salt) {
        return new PasswordEncoder(salt).encode(rawPass);
    }

    /**
     * getSalt 获取加密盐
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/14
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}
