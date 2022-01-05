package com.project.mallproject.otherdemo.guru.chain;

/**
 * @Author lixn
 * @ClassName LinkMiddleware
 * @CreateDate 2021/10/20
 * @Description
 */
public class LinkMiddleware {
    public Middleware init() {
        Server server = new Server();
        Middleware middleware = new ThrottlingMiddleware(2); // head middleware

        // use the function linkWith to link all the middleware in a order  as you want
        middleware.linkWith(new UserExistMiddleware(server))
                .linkWith(new RoleCheckMiddleware());
        return middleware;
    }
}
