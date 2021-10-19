package com.project.mallproject.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.provider.SHA;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;

import static com.project.mallproject.core.common.Constant.PUBLIC_SHA;

/**
 * Description:
 * date: 2021/10/18 3:26 下午
 *
 * @author lixn
 */
public class CommonUtil {
    public static final String KEY_SHA = "SHA";

    public static boolean isNotNull(Object obj) {
        return Objects.nonNull(obj);
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

    // todo 转成一个切面试试
    public Logger createLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
