package com.project.mallproject.other_demo.guru.chain;

/**
 * @Author lixn
 * @ClassName UserExistMiddleware
 * @CreateDate 2021/10/20
 * @Description
 */
public class UserExistMiddleware extends Middleware{
    private Server server;

    public UserExistMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}
