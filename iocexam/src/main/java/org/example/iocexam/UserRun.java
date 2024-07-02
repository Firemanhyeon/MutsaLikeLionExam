package org.example.iocexam;

import org.example.iocexam.config.UserConfig;
import org.example.iocexam.config.UserConfig1;
import org.example.iocexam.controller.UserController;
import org.example.iocexam.controller.UserController1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserRun {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

        UserController userController = (UserController) context.getBean(UserController.class);
        userController.joinUser();


//        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig1.class);
//        UserController1 userController = (UserController1) context.getBean(UserController1.class);
//
//        userController.joinUser();
    }
}
