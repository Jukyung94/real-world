package com.project.realworld.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.project.realworld.dto.LoginUserRequest;
import com.project.realworld.dto.RegisterUserRequest;
import com.project.realworld.entity.RealWorldUser;
import com.project.realworld.entity.Response;
import com.project.realworld.entity.UserResponse;
import com.project.realworld.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/aa")
    public String test() {
        return "hello";
    }

    //Post Request로 회원정보 받아서 서비스로 넘겨주기
    @PostMapping("")
    public ResponseEntity<?> register(final @Valid @RequestBody RegisterUserRequest request) throws Exception {
        return ResponseEntity.ok(ObjectCreater(userService.register(request)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(final @Valid @RequestBody LoginUserRequest request) throws Exception {
        return ResponseEntity.ok(ObjectCreater(userService.login(request)));
    }

    public String ObjectCreater(UserResponse realWorldUser) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(realWorldUser);
        System.out.println(jsonString);
        return jsonString;
    }

}
