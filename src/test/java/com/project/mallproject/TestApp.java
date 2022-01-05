package com.project.mallproject;

import com.project.mallproject.otherdemo.aop.Boy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description:
 * date: 2021/10/26 2:35 下午
 *
 * @author lixn
 */
@SpringBootTest
public class TestApp {
    @Test
    public void test() {
        Boy boy = new Boy();
        boy.buy(111);
    }
}
