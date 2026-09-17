package com.jwt.tutorial.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JUserDto {
    private String username;
    private String password;
    private String role;
}
