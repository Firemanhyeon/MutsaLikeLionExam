package org.example.springjdbc02;

import org.springframework.transaction.annotation.Transactional;

public interface UserDao  {
    @Transactional
    void createAndUpdateUser(String name , String email , String newEmail);//없으면 insert 있으면 update
}
