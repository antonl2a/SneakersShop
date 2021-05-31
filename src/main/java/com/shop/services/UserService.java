package com.shop.services;

import com.shop.models.service.UserRegisterServiceModel;

public interface UserService {
    boolean usernameExists(String username);
    void loginAndRegisterUser(UserRegisterServiceModel userRegisterServiceModel);
    void seedUsers();
    boolean userNameExists(String username);
}
