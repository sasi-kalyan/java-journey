package com.jwt.tutorial.controller;

import com.jwt.tutorial.dto.JUserDto;
import com.jwt.tutorial.entity.JUser;
import com.jwt.tutorial.repository.JUserRepository;
import com.jwt.tutorial.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SignInController {

    private final JUserRepository jUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public SignInController(JUserRepository jUserRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
                            AuthenticationManager authenticationManager) {
        this.jUserRepository = jUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/public/create")
    public String create(@RequestBody JUserDto request){

        JUser jUser = new JUser();
        jUser.setUsername(request.getUsername());
        jUser.setPassword(passwordEncoder.encode(request.getPassword()));
        jUser.setRole("USER");

        jUserRepository.save(jUser);

        return "User saved into db";
    }

    @GetMapping("/auth/verify")
    public String verify(){
        return "User exists in db.";
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody JUserDto jUserDto){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                jUserDto.getUsername(),
                jUserDto.getPassword()
            )
        );

        return "Bearer " + jwtService.generateToken(jUserDto.getUsername());
    }
}
