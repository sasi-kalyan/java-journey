package io.mvc.pattern.demo.service;


import io.mvc.pattern.demo.model.UserDto;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

    public UserDto saveUser(UserDto userDto);

    UserDto getUserDetails(Long id);

    List<UserDto> getAllProperties();

    UserDto updateUser(UserDto userDto, Long id);

    UserDto updateEmailAndDob(UserDto userDto, Long id);

    void deleteUser(Long id);

}
