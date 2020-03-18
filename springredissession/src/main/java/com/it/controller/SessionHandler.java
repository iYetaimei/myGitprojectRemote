package com.it.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionHandler {

    @Value("${server.port}")
    private String port;


    @RequestMapping("/set/{name}")
    public Object set(@PathVariable String name, HttpSession session){
        session.setAttribute("name",this.port+":"+name);
        return session.getAttribute("name");
    };
    @RequestMapping("/get")
    public Object get(HttpSession session){

        return session.getAttribute("name");
    };

}
