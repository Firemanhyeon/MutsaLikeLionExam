package org.blog.jwtexam.service;

import lombok.RequiredArgsConstructor;
import org.blog.jwtexam.domain.Role;
import org.blog.jwtexam.domain.User;
import org.blog.jwtexam.repository.RoleRepository;
import org.blog.jwtexam.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }
}
