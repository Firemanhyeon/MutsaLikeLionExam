package com.example.jpa;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class UserMain {
    //private static final Logger log = LoggerFactory.getLogger(UserMain.class); //애노테이션으로 대체가능.
    public static void main(String[] args) {
        //insert예제
//        UserDAO userDAO = new UserDAO();
//
//        User caramiUser = new User("7777" , "77777.cpm");
//        userDAO.createUser(caramiUser);
//
//
//        log.info("Create user : "+ caramiUser.getName());
//        log.info("user email : {}" , caramiUser.getEmail());

//        //select 예제 id로 찾아오기
//        log.info("findUserTest=============== " );
        UserDAO userDAO = new UserDAO();
//        User findUser = userDAO.findUser(1L);
//        log.info(findUser.getName());
//
//        User findUser2 = userDAO.findUser(1L);
//        if(findUser == findUser2){
//            log.info("findUser == findUser2");
//        } else {
//            log.info("findUser != findUser2");
//        }
//
        //update
//        User user = new User();
//        user.setId(1L);
//        user.setEmail("!@@@@");
//        user.setName("수정");
//        userDAO.updateUser(user);

        //delete
        User user = new User();
        user.setId(2L);
        userDAO.deleteUser(user);
    }
}
