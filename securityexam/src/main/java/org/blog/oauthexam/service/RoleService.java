package org.blog.oauthexam.service;

import lombok.RequiredArgsConstructor;
import org.blog.oauthexam.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

}
