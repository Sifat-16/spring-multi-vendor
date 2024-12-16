package com.wakil.spring_multi_vendor.requests.user;

import com.wakil.spring_multi_vendor.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserRequest {

    private String username;
    private String password;

    public User createUser(){
        return User.builder()
                .username(this.getUsername())
                .password(this.getPassword())
                .build();
    }
}
