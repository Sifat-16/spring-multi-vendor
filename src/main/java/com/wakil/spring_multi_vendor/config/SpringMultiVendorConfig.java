package com.wakil.spring_multi_vendor.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringMultiVendorConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
