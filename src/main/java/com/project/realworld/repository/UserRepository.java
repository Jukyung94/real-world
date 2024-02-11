package com.project.realworld.repository;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.project.realworld.dto.RegisterUserRequest;
import com.project.realworld.entity.RealWorldUser;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
@JsonRootName("user")
public class UserRepository {
    Map<Long, RealWorldUser> userMap = new HashMap();
    Long i = 0L;
    public String registration(RealWorldUser realWorldUser) {
        userMap.put(i, realWorldUser);
        i++;
        System.out.println(userMap.size());
        return "user added";
    }
}
