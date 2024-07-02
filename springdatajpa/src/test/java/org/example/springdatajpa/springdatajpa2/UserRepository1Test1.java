package org.example.springdatajpa.springdatajpa2;

import org.example.springdatajpa.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepository1Test1 {

    private static final Logger log = LoggerFactory.getLogger(UserRepository1Test1.class);

    @Autowired
    UserRepository1 userRepository1;


    @Test
    void findByEmailNative() {
        List<User> userbyEmail = userRepository1.findByEmailNative("123");
        userbyEmail.forEach(user->log.info(user.getEmail()));
    }

    @Test
    void countActiveUserOlderThan30() {

    }

    @Test
    void findUserByNameNative() {
    }
}