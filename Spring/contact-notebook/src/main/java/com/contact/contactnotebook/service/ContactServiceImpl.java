package com.contact.contactnotebook.service;

import com.contact.contactnotebook.model.Contact;
import com.contact.contactnotebook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository repository;

    @Override
    public Contact addContact(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public List<Contact> getContacts() {
        return repository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return repository.findById(id).orElse(new Contact());
    }

    @Override
    public Contact updateContact(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        repository.deleteById(id);
    }

    // Query
    @Override
    public List<Contact> findByCountryCodeLike(String countryCode) {
        return repository.findByCountryCodeLike("%" + countryCode);
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    @Override
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Contact> findByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }
}
