package com.project.mallproject.otherdemo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Description:
 * date: 2021/10/26 10:12 上午
 *
 * @author lixn
 */
/*
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 *
 * Supplier<T> : 供给型接口
 * 		T get();
 *
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 *
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 *
 */

// 方法引用、构造器引用、数组引用 ::
public class FunctionalTest {
    public static void main(String[] args) {
//        testPredicate();
//        testFunction();
//        testSupplier();
//        testConsumer();

        Function<Integer, Integer> add = x -> {
            x += x;
            x++;
            System.out.println(x);
            return x;
        };

        int x = 1;
        add.apply(x);
    }

    // 1、Predicate<T> 断言接口

    public static void testPredicate() {
        List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, s -> s.length() > 3);

        for (String str : strList) {
            System.out.println(str);
        }
    }

    private static List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();

        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }

        return strList;
    }

    // 2、Function<T, R> 函数型接口

    public static void testFunction() {
        String newStr = strHandler("\t\t\t lixn is the NO.1 ", str -> str.trim());
        System.out.println(newStr);

        String subStr = strHandler("lixn is the NO.1", str -> str.substring(2, 5));
        System.out.println(subStr);
    }

    private static String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    // 3、Supplier<T> 供给型接口

    public static void testSupplier() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));

        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    private static List<Integer> getNumList(int size, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(sup.get());
        }

        return list;
    }

    // 4、Consumer<T> 消费型接口

    public static void testConsumer() {
        happy(10000, m -> System.out.println("每天消费" + m + "元"));
    }

    private static void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }
}
