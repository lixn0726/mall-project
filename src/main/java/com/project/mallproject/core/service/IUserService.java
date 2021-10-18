package com.project.mallproject.core.service;

import com.project.mallproject.core.annotation.UserAuthenticate;
import com.project.mallproject.core.model.user.User;

/**
 * Description:
 * date: 2021/10/18 10:43 上午
 *
 * @author lixn
 */
public interface IUserService {
    boolean login(User user);

    String hasAnnotation();

}
