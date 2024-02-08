package com.project.realworld.controller;

import com.project.realworld.dto.RegisterUserRequest;
import com.project.realworld.repository.UserRepository;
import com.project.realworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
//    @GetMapping("/api/hello")
//    public String hello() {
//        return "hello";
//    }

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public String register(@RequestBody RegisterUserRequest request) {
       if(userService.register(request)) return "register success";
       else return "register failed";
    }


}
