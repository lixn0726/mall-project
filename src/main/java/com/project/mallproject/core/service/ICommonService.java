package com.project.mallproject.core.service;

import java.util.List;

/**
 * Description: 所有Service接口的通用模版
 * date: 2021/10/21 9:30 上午
 *
 * @author lixn
 */
public interface ICommonService<T> {
    List<T> fetchAll();

    void delete(T t);

    int update(T t);

    int insert(T t);
}
