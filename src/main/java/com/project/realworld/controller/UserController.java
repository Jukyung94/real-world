package com.project.realworld.controller;

import com.project.realworld.dto.LoginUserRequest;
import com.project.realworld.dto.RegisterUserRequest;
import com.project.realworld.entity.Response;
import com.project.realworld.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/aa")
    public String test() {
        return "hello";
    }

    //Post Request로 회원정보 받아서 서비스로 넘겨주기
    @PostMapping("")
    public ResponseEntity<String> register(final @Valid @RequestBody RegisterUserRequest request) throws Exception {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(final @Valid @RequestBody LoginUserRequest request) throws Exception {
        return ResponseEntity.ok(userService.login(request));
    }


}
