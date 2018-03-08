package com.exam.apirest.services;

import com.exam.apirest.model.Contact;
import org.springframework.data.domain.Page;

public interface ContactService {
	
	public Contact createContact(Contact contact);

	public Contact updateContact(Contact contact, Integer idContact);

	public Contact findByIdContact(Integer idContact);

	public Contact deleteContact(Integer idContact);

	public Contact findByEmail(String email);

	public Page<Contact> findAllByStateOrCity(String state, String city, Integer page, Integer q);
}
