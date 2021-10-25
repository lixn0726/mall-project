package com.project.mallproject.core.common;

import com.project.mallproject.core.model.login.MySession;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * date: 2021/10/25 3:35 下午
 *
 * @author lixn
 */
public interface ConstantVariables {
    // --------- COMMON SALT VALUE TO ENCRYPT ---------
    public static final String PUBLIC_SHA = "sha-value-is-identitied-in-constant";

    // --------- FIXED SSO URL ---------
    public static final String SSO_LOGIN = "http://localhost:" + 8080 + "/sso/login?"; // 没决定要不要
    //    public static final String SSO_DO_LOGIN = "http://localhost:" + PORT + "/sso/doLogin?";
    public static final String SSO_AUTH = "http://localhost:" + 8080 + "/sso/auth?";

    // --------- FIXED COMMON REDIS KEY ---------
    public static final String COOKIE_USER_TICKET = "cookie_user_ticket";
    public static final String REDIS_USER_TOKEN = "redis_user_token"; // 类似于一个全局session
    public static final String REDIS_USER_TICKET = "redis_user_ticket"; // 全局ticket
    public static final String REDIS_TMP_TICKET = "redis_tmp_ticket"; // 暂时性ticket


    // --------- ALGORITHM ---------
    public static final String MD5 = "md5";
    public static final String BASE64 = "base64";
    public static final String SHA = "sha";

    // --------- VIRTUAL STORAGE ---------
    public static Map<String, String> redis = new HashMap<>(16);
    public static Map<String, MySession> ONLINE_USER = new HashMap<>(16);
    public static Map<String, Integer> USER_AUTHORITY = new HashMap<>(16);
    public static Map<String, String> mysql = new HashMap<>(16);
}
