package org.blog.filterexam4.service;

import org.blog.filterexam4.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    @Transactional
    void registerNewUser() {
        User user = new User();
        user.setName("kang2");
        user.setUsername("kang2");
        user.setPassword("12345");
        user.setEmail("kang2@kang.com");

        userService.registerNewUser(user);
    }

    @Test
    void findByUserName() {
    }
}