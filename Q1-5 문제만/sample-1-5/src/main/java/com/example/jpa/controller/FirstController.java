package com.example.jpa.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {
    @RequestMapping(method = RequestMethod.GET, value = "/first-url")
    public ResponseEntity firstUrl(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/helloworld")
    @ResponseBody
    public String helloWorld(){
        return "hello world";
    }


    @GetMapping("/hello-spring")
    @ResponseBody
    public String helloSpring(){
        return "hello spring";
    }
}
