package com.pluralsight.conference.controller;

import javax.validation.Valid;

import com.pluralsight.conference.model.Registration;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration") Registration registration) {
        return "registration";
    }

    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute("registration") Registration registration
                                    ,BindingResult result) {
        
        if (result.hasErrors()) {
            System.out.println("There is errors.");
            return "registration";
        }
        
        System.out.println("Registration:" + registration.getName());
        return "redirect:registration";
    }
}