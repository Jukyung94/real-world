package com.project.realworld.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.project.realworld.dto.LoginUserRequest;
import com.project.realworld.dto.RegisterUserRequest;
import com.project.realworld.entity.RealWorldUser;
import com.project.realworld.entity.Response;
import com.project.realworld.entity.UserResponse;
import com.project.realworld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public UserResponse register(RegisterUserRequest request) throws Exception {
        RealWorldUser realWorldUser = new RealWorldUser(request);
        userRepository.registration(realWorldUser);
        return UserResponse.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .bio("I work at statefarm")
                .image("")
                .token("token")
                .build();
    }

    public UserResponse login(LoginUserRequest request) throws Exception {
        RealWorldUser user = userRepository.login(request);
        return UserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .bio("I work at statefarm")
                .image("")
                .token("token")
                .build();

    }


    public String ObjectCreater(RealWorldUser realWorldUser) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(realWorldUser);
        System.out.println(jsonString);
        return jsonString;
    }
}
