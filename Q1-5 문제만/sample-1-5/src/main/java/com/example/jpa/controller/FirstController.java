package com.example.jpa.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstController {
    @RequestMapping(method = RequestMethod.GET, path = "/first-url")
    public ResponseEntity firstUrl(){
        return new ResponseEntity(HttpStatus.OK);
    }
}
