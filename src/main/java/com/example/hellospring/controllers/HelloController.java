package com.example.hellospring.controllers;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

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

    public String languageHelp(){

        HashMap<String,String> greetings = new HashMap<>();
        String htmlValues = "";
        greetings.put("French","Bonjour");
        greetings.put("Spanish","Hola");
        greetings.put("Italian","Ciao");
        greetings.put("German","Guten Tag");
        greetings.put("Russian","zdras-tvuy-te");

        for (Map.Entry<String,String> values:greetings.entrySet()){
            htmlValues += "<option value=" + values.getValue() + ">" + values.getKey() + "</option>\n";
        }
        return htmlValues;
    }

    // Creates an HTML form and handles get request methods
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){

        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language'>" +
                languageHelp()+
                "</select>"+
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return html;
    }

    // This method handles post from the form method above
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String createMessage(HttpServletRequest request){
        String name = request.getParameter("name");
        String language = request.getParameter("language");

        String html = "<h1>"+language +" " + name + "<h1>";

        return  html;
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
