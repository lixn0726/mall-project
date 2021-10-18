package com.project.mallproject.core.authorization;

import com.project.mallproject.core.model.login.LoginMessage;
import com.project.mallproject.core.util.CommonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.util.UUID;

import static com.project.mallproject.core.common.Constant.PUBLIC_SHA;
import static com.project.mallproject.core.common.Constant.SIGNED_IN;

/**
 * Description:
 * date: 2021/10/18 4:09 下午
 *
 * @author lixn
 */
@RestController
@RequestMapping("/sso")
public class AuthController {
    @RequestMapping("/auth")
    public void auth(@RequestParam("ticket") String ticket, HttpServletResponse response) {
        System.out.println(ticket);

        response.setHeader("token", "hello bae, please save your token carefully");
    }

    @RequestMapping("/login")
    public void login(@RequestParam("username") String username, @RequestParam("pwd")String pwd, HttpServletResponse response) {
        // todo 校验用户名和密码
        String token = CommonUtil.generateToken(username);
        LoginMessage message = new LoginMessage();
        message.setLoginTime(String.valueOf(System.currentTimeMillis()));
        message.setPastTime(String.valueOf(System.currentTimeMillis() + 300000000));
        message.setSalt(PUBLIC_SHA);
        message.setTokenValue(token);
//        message.setRefresh(todo 考虑一下类似于refreshToken的设计);
        SIGNED_IN.put(username, message);
    }
}
