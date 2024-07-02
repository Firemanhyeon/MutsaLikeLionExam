package org.blog.realprojectexam.service;

import lombok.RequiredArgsConstructor;
import org.blog.realprojectexam.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

}
