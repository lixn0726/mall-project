package com.project.mallproject.core.controller;

import com.project.mallproject.core.annotation.SysLog;
import com.project.mallproject.core.annotation.UserAuthenticate;
import com.project.mallproject.core.annotation.UserIdentity;
import com.project.mallproject.core.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 * date: 2021/10/18 3:36 下午
 *
 * @author lixn
 */
@RestController // 相当于@Controller + @ResponseBody，直接返回return的内容，不能返回jsp页面
@RequestMapping("/api")
public class CommonApiController {
    /*
     * @Resource、@Autowired的区别：
     *
     * @Resource Java自身的注解，带有两个重要属性name、type，默认byName，然后才是byType
     *          name: Spring Bean的名字
     *          type: Spring Bean的类型
     * @Autowired Spring的注解，默认byType，只根据type进行自动注入，一般会配合其他的注解一起使用，如
     *          @Qualifier
     *          @Primary
     */
    @Resource(name = "userService")
    private UserServiceImpl userService;



    @SysLog(description = "[hasAnnotation] 判断是否有UserAuthenticate注解")
    @UserAuthenticate(permission = true)
    @RequestMapping("/verifyAnn")
    public String hasAnnotation() {
        return userService.hasAnnotation();
    }

    @RequestMapping("/hi")
    public String hi() {
        return "say hi";
    }
}
