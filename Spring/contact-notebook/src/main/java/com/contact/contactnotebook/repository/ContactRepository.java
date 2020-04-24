package com.contact.contactnotebook.repository;

import com.contact.contactnotebook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByCountryCodeLike(String countryCode);
    List<Contact> findByFirstName(String firstName);
    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
    List<Contact> findByPhoneNumber(String phoneNumber);

}