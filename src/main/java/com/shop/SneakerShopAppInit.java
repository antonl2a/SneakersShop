package com.shop;

import com.shop.services.SneakerService;
import com.shop.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SneakerShopAppInit implements CommandLineRunner {

    private final UserService userService;
    private final SneakerService sneakerService;

    public SneakerShopAppInit(UserService userService, SneakerService sneakerService) {
        this.userService = userService;
        this.sneakerService = sneakerService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.seedUsers();
        sneakerService.seedSneakers();
    }
}
