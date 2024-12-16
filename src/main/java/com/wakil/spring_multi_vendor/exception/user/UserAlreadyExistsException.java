package com.wakil.spring_multi_vendor.exception.user;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException (String message){
        super(message);
    }
}
