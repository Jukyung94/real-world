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

    public RealWorldUser register(RegisterUserRequest request) throws Exception {
        RealWorldUser realWorldUser = new RealWorldUser(request);
        userRepository.registration(realWorldUser);
        return RealWorldUser.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .bio("I work at statefarm")
                .image(null)
                .token("token")
                .build();
    }

    public RealWorldUser login(LoginUserRequest request) throws Exception {
        RealWorldUser user = userRepository.login(request);
        return RealWorldUser.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .bio("I work at statefarm")
                .image(null)
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
