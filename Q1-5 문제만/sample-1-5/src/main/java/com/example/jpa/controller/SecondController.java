package com.example.jpa.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

    @GetMapping("/hello-rest")
    public String helloRest(){
       return "hello rest";
    }


    @GetMapping("/api/helloworld")
    public String helloWorld(){
        return "hello rest api";
    }

}
