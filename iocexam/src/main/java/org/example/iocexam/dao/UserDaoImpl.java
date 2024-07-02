package org.example.iocexam.dao;

import org.example.iocexam.domain.User;



public class UserDaoImpl implements UserDao{


    @Override
    public void addUser(User user) {//저장
        System.out.println(user+"의 정보가 111잘 저장 되었습니다.");
    }
}
