package org.example.iocexam.config;

import org.example.iocexam.controller.UserController;
import org.example.iocexam.dao.UserDao;
import org.example.iocexam.dao.UserDaoImpl;
import org.example.iocexam.service.UserService;
import org.example.iocexam.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    //IoC컨테이너한테 Bean을 등록하는 방법.생각해보고 동작될 수 있도록 작성해주세요
    //1.javaconfig를 이용해서 동작되도록
    //2.componentScan 을 이용해서 동작되도록
    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

    @Bean
    public UserService userService(UserDao userDao) {//userService가 생성될떄 userDao가 필요하기 때문에 넣어준다.
        return new UserServiceImpl(userDao);
    }


    @Bean
    public UserController userController(UserService userService) {
        return new UserController(userService);
    }

}
