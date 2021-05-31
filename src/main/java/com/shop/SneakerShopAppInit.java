package com.shop;

import com.shop.repositories.UserRepository;
import com.shop.repositories.UserRoleRepository;
import com.shop.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SneakerShopAppInit implements CommandLineRunner {

    private final UserService userService;

    public SneakerShopAppInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.seedUsers();
    }
}
