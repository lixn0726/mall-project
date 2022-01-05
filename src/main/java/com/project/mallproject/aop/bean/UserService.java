package com.project.mallproject.aop.bean;

/**
 * @author lixn
 * date: 2021/12/22 4:58 下午
 * <p>
 * Description:
 */
public class UserService implements IUserService{

    private String name = "我是测试";

    public UserService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void queryInfo() {
        System.out.println("query result is " + name);
    }
}
