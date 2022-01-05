package com.project.mallproject.otherdemo.java8;

import java.util.Comparator;
import java.util.function.Supplier;

/**
 * Description:
 * date: 2021/10/26 10:37 上午
 *
 * @author lixn
 */

/*
 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 *
 * 1. 对象的引用 :: 实例方法名
 *
 * 2. 类名 :: 静态方法名
 *
 * 3. 类名 :: 实例方法名
 *
 * 注意：
 * 	 ① 方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 	 ② 若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 */

class Employee {
    int id;
    String name;
    int age;
    double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

public class QuoteTest {
    public static void main(String[] args) {
        testObjectQuote();
    }

    // 对象的引用 :: 实例方法名
    public static void testObjectQuote() {
        Employee employee = new Employee(101, "张三", 18, 99999.99);

        Supplier<String> sup = () -> employee.getName();
        System.out.println(sup.get());

        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        Supplier<String> supplier = employee::getName;
        System.out.println(supplier.get());
    }

    // 类 :: 静态方法
    public static void testClassStatic() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        Comparator<Integer> comparator = Integer::compare;
    }

    // 类 :: 实例方法
    public static void testClassObject() {

    }
}
