package com.project.mallproject.otherdemo.chaindemo;

/**
 * Description:
 * date: 2021/10/20 2:26 下午
 *
 * @author lixn
 */
public class Demo {
    public static void main(String[] args) {
        // 先组装责任链
        Handler h1 = new GeneralManager();
        Handler h2 = new DeptManager();
        Handler h3 = new ProjectManager();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        // --------- testing ---------

        String test1 = h3.handleRequest("张三", 300);
        System.out.println(test1);
        String test2 = h3.handleRequest("李四", 300);
        System.out.println(test2);
        String test3 = h3.handleRequest("张三", 600);
        System.out.println(test3);
        String test4 = h3.handleRequest("李四", 600);
        System.out.println(test4);
        String test5 = h3.handleRequest("张三", 1500);
        System.out.println(test5);
        String test6 = h3.handleRequest("李四", 3000);
        System.out.println(test6);

    }
}
