package com.jwt.jwtauthentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class Home {


    @RequestMapping("/welcome")
    public String welcome(){
        String text ="this is private page";

        text +="this page is not allowed unauthentication users ";

        return text;
    }

    @RequestMapping("/getUsers")
    public String getUsers(){
        return  "{\"name\":\"Durgesh\"}";
    }
}
