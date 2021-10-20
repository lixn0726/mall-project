package com.project.mallproject.other_demo.guru.chain;

/**
 * @Author lixn
 * @ClassName RoleCheckMiddleware
 * @CreateDate 2021/10/20
 * @Description
 */
public class RoleCheckMiddleware extends Middleware{
    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello! admin");
            return true;
        }
        System.out.println("Hello! user");
        return checkNext(email, password);
    }
}
