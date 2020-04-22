package com.contact.contactnotebook.repository;

import com.contact.contactnotebook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("SELECT c FROM Contact c WHERE c.countryCode LIKE CONCAT('%', :countryCode, '%')")
    List<Contact> getContactByCountryCode(@Param("countryCode") String countryCode);
}