package io.mvc.pattern.demo.service.impl;

import io.mvc.pattern.demo.converter.UserConverter;
import io.mvc.pattern.demo.entity.User;
import io.mvc.pattern.demo.exception.BusinessException;
import io.mvc.pattern.demo.exception.ErrorModel;
import io.mvc.pattern.demo.model.UserDto;
import io.mvc.pattern.demo.repository.UserRepository;
import io.mvc.pattern.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userConverter.convertDtoToEntity(userDto);
        userRepository.save(user);

        UserDto resUserDto = userConverter.convertEntityToDto(user);
        return resUserDto;
    }

    @Override
    public UserDto getUserDetails(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            UserDto returnUser = userConverter.convertEntityToDto(user.get());
            return returnUser;
        }

        List<ErrorModel> errorModels = new ArrayList<>();
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode("INVALID_LOGIN");
        errorModel.setMessage("INCORRECT USER ID");
        errorModels.add(errorModel);

        throw new BusinessException(errorModels);
    }

    @Override
    public List<UserDto> getAllProperties() {
        List<User> allUsers = (List<User>) userRepository.findAll();

        List<UserDto> allUserDto = new ArrayList<>();

        for(User user: allUsers){
            UserDto userDto = userConverter.convertEntityToDto(user);
            allUserDto.add(userDto);
        }

        return allUserDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        Optional<User> fetchUser = userRepository.findById(id);

        UserDto newUserDto = null;

        if(fetchUser.isPresent()){
            User user = fetchUser.get();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setDob(userDto.getDob());
            user.setAddress(userDto.getAddress());
            newUserDto = userConverter.convertEntityToDto(user);
            userRepository.save(user);
            return newUserDto;
        }
        return newUserDto;
    }

    @Override
    public UserDto updateEmailAndDob(UserDto userDto, Long id) {
        Optional<User> fetchUser = userRepository.findById(id);

        UserDto newUserDto = null;

        if(fetchUser.isPresent()){
            User user = fetchUser.get();
            user.setEmail(userDto.getEmail());
            user.setDob(userDto.getDob());
            newUserDto = userConverter.convertEntityToDto(user);
            userRepository.save(user);
            return newUserDto;
        }
        return newUserDto;
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> fetchUser = userRepository.findById(id);
        if(fetchUser.isPresent()){
            userRepository.deleteById(id);
        }
    }
}
