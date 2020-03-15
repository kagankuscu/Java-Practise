package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(@RequestParam(value="firstname",defaultValue="kagan") String firstname,
                        @RequestParam(value="lastname",defaultValue="kuscu") String lastname,
                        @RequestParam(value="age",defaultValue="23") int age) {

        User user = new User();

        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);

        return user;
    }

    @PostMapping("/user")
    public User postUser(User user) {
        System.out.println(user.toString());
        
        return user;
    }
}