package com.project.realworld.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.project.realworld.dto.LoginUserRequest;
import com.project.realworld.dto.RegisterUserRequest;
import com.project.realworld.entity.RealWorldUser;
import com.project.realworld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public String register(RegisterUserRequest request) throws JsonProcessingException {
        RealWorldUser realWorldUser = new RealWorldUser();
        realWorldUser.setUsername(request.getUsername());
        realWorldUser.setEmail(request.getEmail());
        realWorldUser.setPassword(request.getPassword());
        if(userRepository.registration(realWorldUser).equals("success")) {
            return ObjectCreater(realWorldUser);
        } else {
            return "The user already exist.";
        }

    }

    public String login(LoginUserRequest request) throws JsonProcessingException {
        RealWorldUser realWorldUser = new RealWorldUser();
        realWorldUser.setEmail(request.getEmail());
        realWorldUser.setPassword(request.getPassword());
        if(userRepository.login(realWorldUser).equals("success")) return ObjectCreater(realWorldUser);
        else return "Invalid user login failed";

    }

    public String ObjectCreater(RealWorldUser realWorldUser) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(realWorldUser);
        System.out.println(jsonString);
        return jsonString;
    }
}
