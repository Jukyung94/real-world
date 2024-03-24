package com.project.realworld.repository;


import com.project.realworld.dto.LoginUserRequest;
import com.project.realworld.entity.RealWorldUser;
import com.project.realworld.entity.Response;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class UserRepository {
    Map<String, RealWorldUser> userMap = new HashMap<>();
    public void registration(RealWorldUser realWorldUser) throws Exception {
        System.out.println(realWorldUser.getEmail());
        if(userMap.containsKey(realWorldUser.getEmail())) {
            throw new Exception("User already exist");
        }
        userMap.put(realWorldUser.getEmail(), realWorldUser);
    }

    public RealWorldUser login(LoginUserRequest request) throws Exception{
        if(!userMap.containsKey(request.getEmail())) {
            throw new Exception("email or password is invalid");
        }
        RealWorldUser user = userMap.get(request.getEmail());
        if(!user.getEmail().equals(request.getEmail()) ||
            !user.getPassword().equals(request.getPassword())) {
            throw new Exception("email or password is invalid");
        }
        return user;
    }
}
