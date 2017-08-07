package com.example.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PublicKey;

@Controller
public class HelloController {

    // This is the route for the webpage
    @RequestMapping(value = "")
    @ResponseBody
    // Returns text Hello World at the root path
    public String index(){
        return "Hello World";
    }
    @RequestMapping(value = "goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye";
    }
}
