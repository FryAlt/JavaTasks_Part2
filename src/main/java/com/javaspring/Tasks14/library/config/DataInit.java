package com.javaspring.Tasks14.library.config;

import com.javaspring.Tasks14.library.entity.User;
import com.javaspring.Tasks14.library.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    private final UserService userService;

    public DataInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        if (userService.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setIsAdmin(true);
            userService.save(admin);
        }
    }
}