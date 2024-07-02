package org.blog.oauthexam.repository;

import org.blog.oauthexam.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    Optional<User> findByProviderAndSocialId(String provider, String socialId);
}
