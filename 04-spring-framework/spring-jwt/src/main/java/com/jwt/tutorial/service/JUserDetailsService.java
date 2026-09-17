package com.jwt.tutorial.service;

import com.jwt.tutorial.entity.JUser;
import com.jwt.tutorial.repository.JUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JUserDetailsService implements UserDetailsService {

    private final JUserRepository jUserRepository;

    public JUserDetailsService(JUserRepository jUserRepository) {
        this.jUserRepository = jUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JUser jUser = jUserRepository.findByUsername(username);
        if (jUser == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return User.builder()
                .username(jUser.getUsername())
                .password(jUser.getPassword())
                .roles(jUser.getRole())
                .build();
    }
}
