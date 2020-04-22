package com.contact.contactnotebook.service;

import com.contact.contactnotebook.model.Contact;

import java.util.List;

public interface ContactService {
    // Create
    Contact addContact(Contact contact);

    // Read
    List<Contact> getContacts();
    Contact getContactById(Long id);

    // Update
    Contact updateContact(Long id, Contact contact);

    // Delete
    void deleteContact(Long id);

    List<Contact> getContactByCountryCode(String countryCode);
}
