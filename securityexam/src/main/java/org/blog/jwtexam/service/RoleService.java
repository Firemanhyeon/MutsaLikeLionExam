package org.blog.jwtexam.service;

import lombok.RequiredArgsConstructor;
import org.blog.jwtexam.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

}
