package com.project.mallproject.core.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description:
 * date: 2021/10/19 4:43 下午
 *
 * @author lixn
 */
public class EncryptUtil {
    public static String encrypt(String data, String algorithmType) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance(algorithmType);
            byte[] md5 = algorithm.digest(data.getBytes(StandardCharsets.UTF_8));
            return new String(md5);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("no such algorithm");
        }
        return null;
    }
}
