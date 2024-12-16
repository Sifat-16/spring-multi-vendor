package com.wakil.spring_multi_vendor.services.user;

import com.wakil.spring_multi_vendor.model.User;
import com.wakil.spring_multi_vendor.requests.user.RegisterUserRequest;


public interface IUserService {
    User registerUser(RegisterUserRequest registerUserRequest);

    User findByUserName(String username);
}
