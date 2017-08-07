package com.example.hellospring.controllers;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@Controller
public class HelloController {

    // This handles the root of the web app
    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request){
        String name = request.getParameter("name");

        // if the query is a null then have is display "Hello World
        if (name == null){
            name = "World";
        }
        return "Hello " + name;
    }

    // Creates an HTML form and handles get request methods
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return html;
    }

    // This method handles post from the form method above
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        return "Hello " + name;
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
    }

    // redirects to the root of the web app if this route is called
    @RequestMapping(value = "goodbye")
    public String goodbye(){
        return "redirect:/";
    }
}
