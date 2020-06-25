package com.thanhnguyen.petclinic.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/hello"
    )
    public String sayHello() {
        System.out.println("Hello world!");
        return "Hi!";
    }
}
