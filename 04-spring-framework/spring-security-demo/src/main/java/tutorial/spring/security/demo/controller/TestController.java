package tutorial.spring.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/public/hello")
    public String publicApi() {
        return "Hello Everyone";
    }

    @GetMapping("/admin/dashboard")
    public String adminApi() {
        return "Admin Dashboard";
    }

    @GetMapping("/home")
    public String home() {
        return "Home";
    }
}
