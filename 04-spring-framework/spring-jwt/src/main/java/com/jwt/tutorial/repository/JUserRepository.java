package com.jwt.tutorial.repository;

import com.jwt.tutorial.entity.JUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JUserRepository extends JpaRepository<JUser, Long> {
    JUser findByUsername(String username);
}
