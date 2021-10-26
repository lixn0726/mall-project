package com.project.mallproject.core;

import com.project.mallproject.core.model.user.User;

/**
 * Description:
 * date: 2021/10/25 4:22 下午
 *
 * @author lixn
 */
public class Demo {
    public static void main(String[] args) {
        User user = new User.Builder()
                .withId("111")
                .withPwd("111")
                .withInfo("111")
                .build();
    }
}
