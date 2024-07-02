package org.example.iocexam.dao;

import org.example.iocexam.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserCaramiDaoImpl implements UserDao{
    @Override
    public void addUser(User user) {
        System.out.println(user+"의 정보를 CaramiDAO 를 통해 저장했습니다.");
    }
}
