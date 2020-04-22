package com.contact.contactnotebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.contact.contactnotebook"})
public class ContactNotebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactNotebookApplication.class, args);
	}

}
