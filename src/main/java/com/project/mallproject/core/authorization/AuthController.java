package com.project.mallproject.core.authorization;

import com.project.mallproject.core.model.login.LoginMessage;
import com.project.mallproject.core.util.CommonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Parameter;
import java.util.Map;

import static com.project.mallproject.core.common.Constant.*;

/**
 * Description:
 * date: 2021/10/18 4:09 下午
 *
 * @author lixn
 */
@RestController
@RequestMapping("/sso")
public class AuthController {

    @RequestMapping("/auth") // doLogin
    public void auth(@RequestParam("ticket") String ticket, HttpServletResponse response) {
        System.out.println(ticket);
    }

    /**
     *
     * @param back 初始URL
     */
    @RequestMapping("/login")
    public void ssoLogin(@RequestParam("back") String back) {

    }
}
