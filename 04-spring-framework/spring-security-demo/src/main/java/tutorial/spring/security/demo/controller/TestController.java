package tutorial.spring.security.demo.controller;

import org.springframework.web.bind.annotation.*;
import tutorial.spring.security.demo.dto.UserInfoDto;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/auth")
    public String login(){
        return "Logged in successfully!!";
    }

    @GetMapping("/pub")
    public String greetings(){
        return "Hi, Spring security enabled.";
    }

}
