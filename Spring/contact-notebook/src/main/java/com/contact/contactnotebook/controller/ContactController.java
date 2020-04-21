package com.contact.contactnotebook.controller;

import com.contact.contactnotebook.model.Contact;
import com.contact.contactnotebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/api/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
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

    @PutMapping(value = {"/{id}"}, consumes = "application/json", produces = "application/json")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        return service.updateContact(id,contact);
    }

    @DeleteMapping({"/{id}"})
    public void  deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
    }

}
