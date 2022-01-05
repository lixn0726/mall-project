package com.project.mallproject.otherdemo.generictype.example;

import java.util.Calendar;

/**
 * @author lixn
 * @date 2021/12/27 15:08
 *
 * 泛型以及限定类型、类型变量的限定Demo
 **/
public class Demo {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy", 80000, 2003, 1, 2);
        Manager cfo = new Manager("Sid Sneaky", 60000, 2003, 3, 11);

        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(100000);
        cfo.setBonus(80000);

        Manager[] managers = { ceo, cfo };
        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + " second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + " second: " + result.getSecond().getName());

    }

    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies");
    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) {
            return;
        }
        Manager min = a[0];
        Manager max = a[0];
        for (Manager manager : a) {
            if (min.getBonus() > manager.getBonus()) {
                min = manager;
            }
            if (max.getBonus() < manager.getBonus()) {
                max = manager;
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
        minmaxBonus(a, result);
        PairArg.swap(result);
    }
}

class PairArg {
    public static boolean hasNull(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
