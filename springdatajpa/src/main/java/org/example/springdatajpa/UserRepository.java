package org.example.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
        List<User> findByName(String name);

        List<User> findByEmail(String email);

        @Modifying
        @Query("update User u set u.email=:email where u.id=:id")
        int updateUserEmail(@Param("id") Long id , @Param("email")String email);

        @Modifying
        @Query("delete from User u where u.id=:id")
        int delete1ById(@Param("id") Long id);
}