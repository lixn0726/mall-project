package com.project.mallproject.core.sso;

/**
 * Description:
 * date: 2021/10/19 11:30 上午
 *
 * @author lixn
 */
public class UserService {
    public boolean queryUsernameIsExist(String username) {
        return true;
    }

    public User createUser() {
        return new User();
    }

    public User queryUserForLogin(String username, String password) {
        return new User();
    }
}
