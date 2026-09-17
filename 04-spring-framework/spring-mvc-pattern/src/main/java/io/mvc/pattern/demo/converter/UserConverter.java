package io.mvc.pattern.demo.converter;

import io.mvc.pattern.demo.entity.User;
import io.mvc.pattern.demo.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convertDtoToEntity(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setDob(userDto.getDob());
        user.setAddress(userDto.getAddress());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setDob(user.getDob());
        userDto.setAddress(user.getAddress());
        return userDto;
    }
}
