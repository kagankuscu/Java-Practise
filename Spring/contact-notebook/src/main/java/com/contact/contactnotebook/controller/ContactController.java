package com.contact.contactnotebook.controller;

import com.contact.contactnotebook.model.Contact;
import com.contact.contactnotebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping
    public Contact addContact(@RequestBody @Valid Contact contact) {
        return service.addContact(contact);
    }

    @GetMapping
    public List<Contact> getContact() {
        return service.getContacts();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return service.getContactById(id);
    }

    @PutMapping(value = {"/{id}"})
    public Contact updateContact(@RequestBody @Valid Contact contact) {
        return service.updateContact(contact);
    }

    @DeleteMapping({"/{id}"})
    public void  deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
    }

    // Query
    @GetMapping({"/countryCode"})
    @ResponseBody
    public List<Contact> searchPhoneNumberByCountryCode(@RequestParam String countryCode) {
        return service.findByCountryCodeLike(countryCode);
    }

    @GetMapping("/firstName")
    @ResponseBody
    public List<Contact> searchPhoneNumberByFirstName(@RequestParam String firstName) {
        return service.findByFirstName(firstName);
    }

    @GetMapping({"/firstNameAndLastName"})
    @ResponseBody
    public List<Contact> searchPhoneNumberByFirstAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping({"/phoneNumber"})
    @ResponseBody
    public List<Contact> searchPhoneNumberByPhoneNumber(@RequestParam String phoneNumber) {
        return service.findByPhoneNumber(phoneNumber);
    }
}