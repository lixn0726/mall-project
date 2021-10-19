package com.project.mallproject.core.authorization;

import com.project.mallproject.core.enums.ErrorCode;
import com.project.mallproject.core.exception.CustomException;
import com.project.mallproject.core.util.CommonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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
    public String ssoLogin(String userId, String password, String back, HttpServletResponse response) {
        if (!CommonUtil.isNotNull(userId, password)) { // 参数判空
            throw new CustomException(ErrorCode.ERROR_ARG);
        }
        if (!mysql.containsKey(userId) || !password.equals(mysql.get(userId))) { // 数据验证
            throw new CustomException(ErrorCode.ERROR_LOGIN);
        }
        String uniqueToken = UUID.randomUUID().toString().trim();
        return null;
    }

    @RequestMapping("/auth")
    public void ssoAuth(@RequestParam("ticket") String ticket, HttpServletResponse response) {

    }

    // --------- private function ---------

}
