package com.project.mallproject.core.service.impl;

import com.project.mallproject.core.model.user.User;
import com.project.mallproject.core.service.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Description:
 * date: 2021/10/18 2:42 下午
 *
 * @author lixn
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public String hasAnnotation() {
        return "I have this annotation";
    }
}
