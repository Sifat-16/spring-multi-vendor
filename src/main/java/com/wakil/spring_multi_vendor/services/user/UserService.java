package com.wakil.spring_multi_vendor.services.user;

import com.wakil.spring_multi_vendor.exception.user.UserAlreadyExistsException;
import com.wakil.spring_multi_vendor.model.User;
import com.wakil.spring_multi_vendor.requests.user.RegisterUserRequest;
import com.wakil.spring_multi_vendor.respository.user.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    final UserRepository userRepository;

    @Override
    public User registerUser(RegisterUserRequest registerUserRequest) {
        Optional<User> user = userRepository.findByUsername(registerUserRequest.getUsername());
        if(user.isEmpty()){
            try {
                return userRepository.save(registerUserRequest.createUser());
            }catch (Exception e){
                throw new UserAlreadyExistsException("User already exists -- DB error");
            }

        }else{
            throw new UserAlreadyExistsException("User already exists");
        }

    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Your user is not in our database"));
    }
}
