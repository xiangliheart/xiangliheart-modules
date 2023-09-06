/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiangliheart.modules.frame.core.frame.web.http.HttpResult;
import com.xiangliheart.modules.service.admin.entity.SysUser;
import com.xiangliheart.modules.service.admin.service.SysCustomerUserService;
import com.xiangliheart.modules.service.admin.vo.LoginBean;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.xiangliheart.modules.frame.core.frame.security.security.JwtAuthenticatioToken;
import com.xiangliheart.modules.frame.core.frame.security.utils.PasswordUtils;
import com.xiangliheart.modules.frame.core.frame.security.utils.SecurityUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * LoginController 登录控制器
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/10
 */
@RestController
@Api(tags = "用户登录-SysAmCustomerUserController")
public class SysLoginController {

    @Autowired
    private Producer producer;
    @Autowired
    private SysCustomerUserService sysAmCustomerUserService;
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * captcha 校验码
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/7/10
     */
    @GetMapping("captcha")
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * login 登录接口
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/7/10
     */
    @PostMapping(value = "/login")
    @ApiOperation(value = "登入", notes = "登入")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (kaptcha == null) {
            return HttpResult.error("验证码已失效");
        }
        if (!captcha.equals(kaptcha)) {
            return HttpResult.error("验证码不正确");
        }
        // 用户信息
        SysUser customerUser = sysAmCustomerUserService.findByCustomerUserName(username);
        // 账号不存在、密码错误
        if (customerUser == null) {
            return HttpResult.error("账号不存在");
        }
        if (!PasswordUtils.matches(customerUser.getSalt(), password, customerUser.getPassword())) {
            return HttpResult.error("密码不正确");
        }
        // 账号锁定
        if (customerUser.getStatus() == 0) {
            return HttpResult.error("账号已被锁定,请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok(token);
    }
}
