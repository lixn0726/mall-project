package com.project.mallproject.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;

import static com.project.mallproject.core.common.Constant.*;


/**
 * Description:
 * date: 2021/10/18 3:26 下午
 *
 * @author lixn
 */
public class CommonUtil {
    public static final String KEY_SHA = "SHA";

    public static boolean isNotNull(Object ... obj) {
        boolean flag = true;
        for (Object o : obj) {
            if (!Objects.nonNull(o)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static String createTmpTicket() {
        String tmpTicket = UUID.randomUUID().toString().trim();
        redis.put(REDIS_TMP_TICKET + ":" + tmpTicket, EncryptUtil.encrypt(tmpTicket, MD5));
        return tmpTicket;
    }

    public static String toRedirect(HttpServletRequest request, String redirectType) {
        StringBuffer buffer = new StringBuffer();
        String back = request.getRequestURL().toString(); // 原始url
        buffer.append(redirectType).append("back=").append(back);
        return buffer.toString();
    }

    public static String generateToken(String username) {
        String uuid = UUID.randomUUID().toString().replace("-", "") + username;
        String sha = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(uuid.getBytes());
            sha = String.valueOf(new BigInteger(messageDigest.digest()));
            System.out.println(sha);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("no such algorithm");
            e.printStackTrace();
        }
        return sha;
    }

    // todo 转成一个日志切面试试
    public static Logger createLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

//    public static Map<String, String> getURLParams(String url) {
//        String urlQueries = url.substring(url.indexOf("?") + 1);
//        if (urlQueries.length() == 0) {
//            return null;
//        }
//        String[] queries = urlQueries.split("&");
//        /*
//         * String[0] = "xx=xxx"
//         * String[1] = "xxx=xxxxxxx"
//         */
//        Map<String, String> params = new HashMap<>();
//        for (String par : queries) {
//            params.put(par.split("=")[0], par.split("=")[1]);
//        }
//        return params;
//    }
}
