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
    private ContactRepository contactRepository;

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(new Contact());
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        Contact updateContact = getContactById(id);
        updateContact.setFirstName(contact.getFirstName());
        updateContact.setLastName(contact.getLastName());
        updateContact.setCountryCode(contact.getCountryCode());
        updateContact.setPhoneNumber(contact.getPhoneNumber());
        return contactRepository.save(updateContact);
    }

    @Override
    public void deleteContact(Long id) {
        Contact deleteContact = new Contact();
        deleteContact = getContactById(id);
        contactRepository.delete(deleteContact);
    }
}
