package com.contact.contactnotebook.controller;

import com.contact.contactnotebook.model.Contact;
import com.contact.contactnotebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Contact addContact(@RequestBody Contact contact) {
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

    @PutMapping(value = {"/{id}"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Contact updateContact(@PathVariable Long id, @RequestBody @Valid Contact contact) {
        return service.updateContact(id,contact);
    }

    @DeleteMapping({"/{id}"})
    public void  deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
    }

    @GetMapping({"/countryCode/{countryCode}"})
    public List<Contact> searchPhoneNumberByCountryCode(@PathVariable String countryCode) {
        String addPlus = "+" + countryCode;
        return service.getContactByCountryCode(countryCode);
    }
}
