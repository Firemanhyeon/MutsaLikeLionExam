package org.example.iocexam.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import org.example.iocexam.domain.User;
import org.example.iocexam.service.UserService;
import org.example.iocexam.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    public UserController(UserService userService){
        System.out.println("userController 생성자 호출");
        this.userService = userService;
    }

    @PostConstruct
    public void init(){
        // 해당 빈이 생성된 직후 호출됨
        System.out.println("postConstruct 실행");
    }

    public void joinUser(){
        // 실제 동작할 때는 사용자로부터 정보를 받아온다.
        // 여기서는 간단한 정보를 설정하여 호출한다.
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setPassword("123456");
        user.setName("admin");
        userService.joinUser(user);
    }

    @PreDestroy
    public void destroy(){
        // 빈이 소멸되기 직전에 호출됨
        System.out.println("destroy 호출");
    }
}
