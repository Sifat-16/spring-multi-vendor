package com.wakil.spring_multi_vendor.exception.files;

public class FileNotFoundException extends RuntimeException{
    public FileNotFoundException(String message){
        super(message);
    }
}
