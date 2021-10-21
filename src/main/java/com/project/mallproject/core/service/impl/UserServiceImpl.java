package com.project.mallproject.core.service.impl;

import com.project.mallproject.core.model.user.User;
import com.project.mallproject.core.service.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * date: 2021/10/18 2:42 下午
 *
 * @author lixn
 */
@Service
public class UserServiceImpl extends CommonServiceImpl<User> implements IUserService {
    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public String hasAnnotation() {
        return "I have this annotation";
    }

    @Override
    public List<User> fetchAll() {
        return super.fetchAll();
    }

    @Override
    public void delete(User user) {
        super.delete(user);
    }

    @Override
    public int update(User user) {
        return super.update(user);
    }

    @Override
    public int insert(User user) {
        return super.insert(user);
    }
}
