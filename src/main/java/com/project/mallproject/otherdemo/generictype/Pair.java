package com.project.mallproject.otherdemo.generictype;

/**
 * @author lixn
 * @date 2021/12/27 11:50
 **/
public class Pair<T> {
    private T first;

    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
