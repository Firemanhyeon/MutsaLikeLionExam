package org.blog.filterexam4.service;

import lombok.RequiredArgsConstructor;
import org.blog.filterexam4.entity.Role;
import org.blog.filterexam4.entity.User;
import org.blog.filterexam4.repository.RoleRepository;
import org.blog.filterexam4.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
   private final UserRepository userRepository;
   private final RoleRepository roleRepository;

   @Transactional
   public User registerNewUser(User user){
       Role userRole = roleRepository.findByName("ROLE_USER");
       user.setRoles(Collections.singleton(userRole));
       return userRepository.save(user);
   }

   public User findByUserName(String username){

        return userRepository.findByUsername(username);
   }
}
