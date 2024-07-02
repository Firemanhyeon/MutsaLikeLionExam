package org.blog.realprojectexam.service;

import lombok.RequiredArgsConstructor;
import org.blog.realprojectexam.domain.Role;
import org.blog.realprojectexam.domain.User;
import org.blog.realprojectexam.repository.RoleRepository;
import org.blog.realprojectexam.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    //회원가입
    public User registUser(User user){
        //role설정
        Role userRole = roleRepository.findByName("USER");
        user.setRoles(Collections.singleton(userRole));
        //패스워드 인코딩 (시큐리티는 무조건 인코딩 해줘야한다.). password암호화
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findByUserName(String username){
        return userRepository.findByUsername(username);
    }
}
