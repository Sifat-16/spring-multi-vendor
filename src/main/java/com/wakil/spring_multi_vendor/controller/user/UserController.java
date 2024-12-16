package com.wakil.spring_multi_vendor.controller.user;

import com.wakil.spring_multi_vendor.model.User;
import com.wakil.spring_multi_vendor.requests.user.RegisterUserRequest;
import com.wakil.spring_multi_vendor.response.ApiResponse;
import com.wakil.spring_multi_vendor.services.jwt.JwtService;
import com.wakil.spring_multi_vendor.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/auth")
@RequiredArgsConstructor
public class UserController {
    final UserService userService;
//    final AuthenticationManager authenticationManager;
//    final PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    ResponseEntity<ApiResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        try {
            //registerUserRequest.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
           User user = userService.registerUser(registerUserRequest);
           return ResponseEntity.ok(new ApiResponse("new user created", user));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("failed to create user", e.getMessage()));
        }

    }

    @PostMapping("/login")
    ResponseEntity<ApiResponse> login(@RequestBody RegisterUserRequest registerUserRequest){

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(registerUserRequest.getUsername(), registerUserRequest.getPassword()));
            if(authentication.isAuthenticated()){
                return ResponseEntity.ok(new ApiResponse("Logged In", jwtService.generateToken(registerUserRequest.getUsername())));
            }else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiResponse("Logged In Failed", "Invalid Credentials"));

            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("failed to create user", e.getMessage()));
        }

    }


//    @PostMapping("/login")
//    ResponseEntity<ApiResponse> loginUser(@RequestBody RegisterUserRequest registerUserRequest){
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(registerUserRequest.getUsername(), registerUserRequest.getPassword())
//            );
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            return ResponseEntity.ok(new ApiResponse("user logged in", authentication.getDetails()));
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("failed to logged in user", e.getMessage()));
//        }
//
//    }
}
