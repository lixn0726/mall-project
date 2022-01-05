package com.project.mallproject.otherdemo.proxy.staticproxy;

/**
 * Description:
 * date: 2021/10/26 3:18 下午
 *
 * @author lixn
 */
public interface IWork {
    void meeting();

    int evaluate(String name);

    IWork work(String subject);
}
