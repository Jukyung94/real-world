package com.project.realworld.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonRootName("user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private String username;
    private String email;
    private String token;
    private String bio;
    private String image;

}
