package com.contact.contactnotebook.repository;

import com.contact.contactnotebook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
