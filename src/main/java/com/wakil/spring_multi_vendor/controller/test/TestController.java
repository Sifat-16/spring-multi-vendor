package com.wakil.spring_multi_vendor.controller.test;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String homePage(HttpServletRequest httpServletRequest){
        return "Hello Sifat " + httpServletRequest.getRequestedSessionId();
    }


    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");

    }



    @PostMapping("/")
    public String homePagePost(HttpServletRequest httpServletRequest){
        return "Hello Sifat " + httpServletRequest.getRequestedSessionId();
    }

}
