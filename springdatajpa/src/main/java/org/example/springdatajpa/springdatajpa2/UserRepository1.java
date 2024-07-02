package org.example.springdatajpa.springdatajpa2;

import org.example.springdatajpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository1 extends JpaRepository<User,Long> {

    @Query(value = "select * from jpa_user where email like %?1%" , nativeQuery = true)
    List<User> findByEmailNative(String email);

    @Query(value = "SELECT count(*) from jpa_user where age > 30 AND status = 'ACTIVE'",nativeQuery = true)
    int countActiveUserOlderThan30();

    @Query(value = "select name , email from jpa_user where name like %:name%" , nativeQuery = true)
    List<Object[]> findUserByNameNative();
}
