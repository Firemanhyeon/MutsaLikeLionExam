package org.example.iocexam.controller;

import org.example.iocexam.domain.User;
import org.example.iocexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Controller
public class UserController1 {

    private UserService userService;





    public void joinUser(){
        //실제 동작할 때는 사용자로 부터 정보를 받아온다.

        //여기서는 그냥 정보를 써준다.
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setPassword("123456");
        user.setName("admin");
        userService.joinUser(user);
    }
}
