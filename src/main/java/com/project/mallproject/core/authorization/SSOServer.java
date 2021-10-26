package com.project.mallproject.core.authorization;


import com.project.mallproject.core.chain.AccessHandler;
import com.project.mallproject.core.chain.AliveHandler;
import com.project.mallproject.core.chain.NotNullHandler;
import com.project.mallproject.core.enums.ErrorCode;
import com.project.mallproject.core.exception.CustomException;
import com.project.mallproject.core.util.CommonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

import static com.project.mallproject.core.common.Constant.*;

/**
 * Description:
 * date: 2021/10/18 4:09 下午
 *
 * @author lixn
 */
@RestController
@RequestMapping("/sso")
public class SSOServer {

    @RequestMapping("/login")
    public String ssoLogin(String userId, String password, String back, HttpServletResponse response) throws IOException {
        if (!CommonUtil.isNotNull(userId, password)) { // 参数判空
            throw new CustomException(ErrorCode.ERROR_ARG);
        }
        if (!mysql.containsKey(userId) || !password.equals(mysql.get(userId))) { // 数据验证
            throw new CustomException(ErrorCode.ERROR_LOGIN);
        }
        // todo 添加一个加密的串作为存储的redis value
        String uniqueToken = UUID.randomUUID().toString().trim();
        redis.put(REDIS_USER_TOKEN + ":" + userId, uniqueToken);
        // 生成全局 userTicket用户全局门票，代表用户在该CAS端登陆过
        String userTicket = UUID.randomUUID().toString().trim();
        // 全局门票
        setCookie(COOKIE_USER_TICKET + ":" + userId, userId, response);
        redis.put(REDIS_USER_TICKET + ":" + userTicket, userId);
        // 生成临时票据，回调给调用端的url
        String tmpTicket = CommonUtil.createTmpTicket();
        response.sendRedirect(back + "?tmpTicket=" + tmpTicket);
        return null;
    }
    /*
     * 验证ticket，拿到token
     * 责任链模式的版本
     * CustomChain chain = new CustomChain();
     * chain.filtrate(tmpTicket, tmpTicketValue);
     * 因为如果参数不合法，每个处理器都会抛出异常中断程序
     * response.sendRedirect(url);
     */
    @RequestMapping("/auth")
    public void ssoAuth(@RequestParam("tmpTicket") String tmpTicket, HttpServletRequest request, HttpServletResponse response) throws IOException{
        String tmpTicketValue = redis.get(REDIS_TMP_TICKET + ":" + tmpTicket);
        // 改进责任链模式
        NotNullHandler handler = new NotNullHandler();
        handler.linkWith(new AccessHandler(request)).linkWith(new AliveHandler());
        if (handler.check(tmpTicket, tmpTicketValue)) {
            // todo
            response.sendRedirect("");
        } else {
            throw new CustomException(ErrorCode.ERROR_TICKET);
        }
    }

    @RequestMapping("/logout")
    public void ssoLogout() {

    }

    // --------- private function ---------

    private static void setCookie(String key, String val, HttpServletResponse response) {
        Cookie cookie = new Cookie(key, val);
        cookie.setDomain("sso.com");
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    private static String getCookie(HttpServletRequest request, String key) {
        Cookie[] cookieList = request.getCookies();
        for (Cookie cookie : cookieList) {
            if (key.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
