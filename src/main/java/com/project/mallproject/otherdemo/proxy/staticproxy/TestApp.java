package com.project.mallproject.otherdemo.proxy.staticproxy;

/**
 * Description:
 * date: 2021/10/26 3:21 下午
 *
 * @author lixn
 */
/*
 * 静态代理和装饰者模式的区别：
 *      1、装饰者模式专注于在一个对象上动态的添加方法，而代理模式专注于控制对对象的访问
 *      2、用代理模式，代理类可以对它的客户隐藏一个对象的具体信息，所以在使用代理模式的时候，经常在一个代理类创建一个对象的实例
 *      3、使用装饰着模式的时候，通常都是将原始对象当成参数传递给装饰者模式的构造器
 *      4、In a word，使用代理模式，代理和真实对象的关系在编译时就确定了，而装饰者模式可以在运行时递归构造
 */
public class TestApp {
    public static void main(String[] args) {
        Leader leader = new Leader();
        Secretary secretary = new Secretary(leader);
        secretary.meeting();
        secretary.evaluate("Joy");
    }
}


