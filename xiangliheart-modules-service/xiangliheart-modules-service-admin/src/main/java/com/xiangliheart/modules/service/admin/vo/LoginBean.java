/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * LoginBean
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/10
 */
@Getter
@Setter
public class LoginBean {
    @ApiModelProperty(value = "登录账号")
    private String account;
    @ApiModelProperty(value = "登录密码")
    private String password;
    @ApiModelProperty(value = "登录验证码")
    private String captcha;
}
