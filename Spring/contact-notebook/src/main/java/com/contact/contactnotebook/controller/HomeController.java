package com.contact.contactnotebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class HomeController {

    @GetMapping
    public void index() {
        System.out.println("hello world");
    }
}
