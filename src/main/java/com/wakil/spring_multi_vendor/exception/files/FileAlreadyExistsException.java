package com.wakil.spring_multi_vendor.exception.files;

public class FileAlreadyExistsException extends RuntimeException{
    public FileAlreadyExistsException(String message){
        super(message);
    }
}
