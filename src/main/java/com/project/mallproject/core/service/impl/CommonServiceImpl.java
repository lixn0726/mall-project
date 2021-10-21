package com.project.mallproject.core.service.impl;

import com.project.mallproject.core.service.ICommonService;

import java.util.List;

/**
 * Description:
 * date: 2021/10/21 9:55 上午
 *
 * @author lixn
 */
public class CommonServiceImpl<T> implements ICommonService<T> {
    @Override
    public List<T> fetchAll() {
        return null;
    }

    @Override
    public void delete(T t) {

    }

    @Override
    public int update(T t) {
        return 0;
    }

    @Override
    public int insert(T t) {
        return 0;
    }
}
