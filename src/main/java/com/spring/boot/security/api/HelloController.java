package com.spring.boot.security.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello(){
        return "<h2>Hello</h2><br/><h2>I have view permission</h2>";
    }

    @GetMapping("/user")
    public String userResource(){
        return "<h2>Hello User</h2><br/><h2>I have only read permission</h2>";
    }

    @GetMapping("/admin")
    public String adminResource(){
        return "<h2>Hello Admin</h2><br/><h2>I have write permission</h2>";
    }
}
