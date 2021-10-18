package com.project.mallproject.core.common;

import com.project.mallproject.core.model.login.LoginMessage;
import com.project.mallproject.core.model.login.MySession;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * date: 2021/10/18 4:35 下午
 *
 * @author lixn
 */
public class Constant {
    private static final String PORT = "8081";

    static {
        init(); // 准备一些初始数据
    }

    public static String REDIRECT_TO_LOGIN = "http://localhost:" + PORT + "/sso/login?";
    public static final String PUBLIC_SHA = "sha-value-is-identitied-in-constant";

    public static Map<String, LoginMessage> SIGNED_IN = new HashMap<>(16);
    public static Map<String, MySession> CURRENT_SYSTEM = new HashMap<>(16);
    public static Map<String, Integer> USER_AUTHORITY = new HashMap<>(16);

    // ------ private function
    private static void init() {
        USER_AUTHORITY.put("eddy", 3);
        USER_AUTHORITY.put("mason", 3);
        USER_AUTHORITY.put("youngAnd", 2);
        USER_AUTHORITY.put("user", 1);
    }
}
