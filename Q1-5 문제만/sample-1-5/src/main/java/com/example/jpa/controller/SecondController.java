package com.example.jpa.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

    @GetMapping("/hello-rest")
    public String hellorest(){
       return "hello rest";
    }

}
