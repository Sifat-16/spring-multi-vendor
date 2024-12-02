package com.wakil.spring_multi_vendor.exception.product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message){
        super(message);
    }
}
