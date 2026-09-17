package io.mvc.pattern.demo.controller;

import io.mvc.pattern.demo.model.UserDto;
import io.mvc.pattern.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")

public class UserController {

    @Autowired(required = true)
    private UserService userService;

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello";
    }

    @PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.saveUser(userDto);
        return userDto1;
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllProperties(){
        List<UserDto> allUserDto = userService.getAllProperties();
        ResponseEntity<List<UserDto>> responseEntity = new ResponseEntity<>(allUserDto, HttpStatus.FOUND);

        return responseEntity.getBody();
    }

    @GetMapping(path = "/getUser/{id}", consumes = {"application/json"}, produces = {"application/json"})
    public UserDto getUserDetails(@PathVariable Long id){
        UserDto userDto = userService.getUserDetails(id);
        ResponseEntity<UserDto> responseEntity = new ResponseEntity<>(userDto, HttpStatus.FOUND);
        return responseEntity.getBody();
    }

    @PutMapping("/update/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Long id){
        UserDto userDto1 = userService.updateUser(userDto, id);
        ResponseEntity<UserDto> responseEntity = new ResponseEntity<>(userDto1, HttpStatus.FOUND);
        return responseEntity.getBody();
    }

    @PatchMapping("/updateEmailDob/{id}")
    public UserDto updateEmailAndDob(@RequestBody UserDto userDto, @PathVariable Long id){
        UserDto userDto1 = userService.updateEmailAndDob(userDto, id);
        ResponseEntity<UserDto> responseEntity = new ResponseEntity<>(userDto1, HttpStatus.FOUND);
        return responseEntity.getBody();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }

}
