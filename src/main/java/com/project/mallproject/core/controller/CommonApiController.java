package com.project.mallproject.core.controller;

import com.project.mallproject.core.annotation.UserAuthenticate;
import com.project.mallproject.core.annotation.UserIdentity;
import com.project.mallproject.core.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * date: 2021/10/18 3:36 下午
 *
 * @author lixn
 */
@RestController
@RequestMapping("/api")
public class CommonApiController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/verifyAnn")
    @UserAuthenticate(permission = true)
    public String hasAnnotation() {
        return userService.hasAnnotation();
    }
}
