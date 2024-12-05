package com.wakil.spring_multi_vendor.exception.files;

public class FileSaveFailedException extends RuntimeException{
    public FileSaveFailedException(String message){
        super(message);
    }
}
