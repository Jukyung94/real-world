package com.project.realworld.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.project.realworld.dto.RegisterUserRequest;
import lombok.*;

import java.util.List;

@Data
@Builder
@JsonRootName("user")
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class RealWorldUser {
    public String username;
    public String email;
    public String password;
    public String token;
    public String bio;
    public String image;


    public RealWorldUser(RegisterUserRequest request) {
        this.username = request.getUsername();
        this.email = request.getEmail();
        this.password = request.getPassword();
    }
}
