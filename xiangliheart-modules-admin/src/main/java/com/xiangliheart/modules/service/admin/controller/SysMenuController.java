/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.admin.controller;

import java.util.List;

import com.xiangliheart.modules.frame.core.frame.web.http.HttpResult;
import com.xiangliheart.modules.service.admin.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiangliheart.modules.service.admin.entity.SysMenu;

/**
 * SysMenuController 菜单控制器
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/11/27
 */
@RestController
@RequestMapping("菜单管理-menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysAhMenuService;

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysMenu record) {
        return HttpResult.ok(sysAhMenuService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysMenu> records) {
        return HttpResult.ok(sysAhMenuService.delete(records));
    }

    @GetMapping(value = "/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        return HttpResult.ok(sysAhMenuService.findTree(userName, 1));
    }

    @GetMapping(value = "/findMenuTree")
    public HttpResult findMenuTree() {
        return HttpResult.ok(sysAhMenuService.findTree(null, 0));
    }
}
