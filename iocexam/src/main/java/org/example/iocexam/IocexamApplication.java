package org.example.iocexam;

import org.example.iocexam.config.UserConfig;
import org.example.iocexam.config.UserConfig1;
import org.example.iocexam.controller.UserController;
import org.example.iocexam.controller.UserController1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class IocexamApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocexamApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

        UserController userController = (UserController) context.getBean(UserController.class);
        userController.joinUser();
    }

}
