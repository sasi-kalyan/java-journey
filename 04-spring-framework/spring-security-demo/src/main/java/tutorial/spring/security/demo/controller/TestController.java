package tutorial.spring.security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tutorial.spring.security.demo.dto.UserObj;
import tutorial.spring.security.demo.service.UserObjService;

@RestController
@RequestMapping("/api")
public class TestController{

    private UserObjService userObjService;

    public TestController(UserObjService userObjService) {
        this.userObjService = userObjService;
    }

    @GetMapping("/user")
    public String greetUser(){
        return "Welcome `user` to home-page";
    }

    @GetMapping("/admin")
    public String greetAdmin(){
        return "Welcome `admin` to home-page";
    }

    @PostMapping("/user/create")
    public ResponseEntity<UserObj> createUser(@RequestBody UserObj userObj){
        UserObj userObj1 = userObjService.createUser(userObj);
        return new ResponseEntity<>(userObj1, HttpStatus.CREATED);
    }
}