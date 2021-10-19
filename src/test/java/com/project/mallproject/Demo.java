package com.project.mallproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * Description:
 * date: 2021/10/18 5:01 下午
 *
 * @author lixn
 */
public class Demo {
    @Test
    public void test() {
        String back = "http://localhost:8180/sso/api?back=xxx";
        String originURL = back.substring(back.indexOf("=") + 1);
        System.out.println(originURL);
    }
}
