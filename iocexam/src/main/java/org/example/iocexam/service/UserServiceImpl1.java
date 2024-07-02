package org.example.iocexam.service;

import org.example.iocexam.dao.UserDao;
import org.example.iocexam.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl1 implements UserService{

    private UserDao userDao;

    @Autowired
    @Qualifier("userDaoImpl1")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void joinUser(User user) {
        //회원가입을 위한 비즈니스 코드가 작성.

        //회원가입 위한 비즈니스가 끝나면 해당 데이터를 저장하는 코드가 실행.
        userDao.addUser(user);
    }
}
