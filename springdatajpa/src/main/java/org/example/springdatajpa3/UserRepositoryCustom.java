package org.example.springdatajpa3;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findUsersByName(String name);
}