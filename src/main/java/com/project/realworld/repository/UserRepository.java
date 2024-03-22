package com.project.realworld.repository;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.project.realworld.dto.RegisterUserRequest;
import com.project.realworld.entity.RealWorldUser;
import lombok.Builder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class UserRepository {
    Map<Long, RealWorldUser> userMap = new HashMap<>();
    Long i = 0L;
    public String registration(RealWorldUser realWorldUser) {
        var values = userMap.values();
        boolean isUserExist = false;

        //Map에서 유저가 있는지 검증
        if(values.isEmpty()) {
            userMap.put(i, realWorldUser);
            i++;
            isUserExist = false;
        } else {
            for (RealWorldUser value : values) {
                if(Objects.equals(value.email, realWorldUser.email)) {
                    isUserExist = true;
                } else {
                    userMap.put(i, realWorldUser);
                    i++;
                    isUserExist = false;
                }
            }
        }
        if(!isUserExist) return "success";
        else return "user already exist";
    }

    public String login(RealWorldUser realWorldUser) {
        var values = userMap.values();
        boolean isUserExist = false;

        //Map에서 유저가 있는지 검증
        if(values.isEmpty()) {
            isUserExist = false;
        } else {
            for (RealWorldUser value : values) {
                System.out.println(value);
                isUserExist = Objects.equals(value.email, realWorldUser.email);
            }
        }
        if(!isUserExist) return "failed";
        else return "success";
    }
}
