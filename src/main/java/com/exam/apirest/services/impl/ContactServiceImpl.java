package com.exam.apirest.services.impl;

import com.exam.apirest.exceptions.ResourceNotFoundException;
import com.exam.apirest.model.Contact;
import com.exam.apirest.repositories.ContactRepository;
import com.exam.apirest.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contact){
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact, Integer idContact){
        Contact searchedContact = contactRepository.findByIdContact(idContact);

        if (searchedContact == null){
            throw new ResourceNotFoundException(idContact);
        } else {
            searchedContact.setAddress(contact.getAddress());
            searchedContact.setBirthDate(contact.getBirthDate());
            searchedContact.setCompany(contact.getCompany());
            searchedContact.setEmail(contact.getEmail());
            searchedContact.setName(contact.getName());
            searchedContact.setPhoneNumberPersonal(contact.getPhoneNumberPersonal());
            searchedContact.setPhoneNumberWork(contact.getPhoneNumberWork());
            searchedContact.setProfileImage(contact.getProfileImage());
        }
        return contactRepository.save(searchedContact);
    }

    @Override
    public Contact findByIdContact(Integer idContact){
        Contact contact = contactRepository.findByIdContact(idContact);
        if (contact == null) {
            throw new ResourceNotFoundException(idContact);
        } else {
            return contact;
        }
    }

    @Override
    public Contact deleteContact(Integer idContact){
        Contact contact = contactRepository.findByIdContact(idContact);
        if (contact == null) {
            throw new ResourceNotFoundException(idContact);
        } else {
            contactRepository.delete(contact);
        }

        return contact;
    }

    @Override
    public Contact findByEmail(String email){
        return contactRepository.findByEmail(email);
    }

    @Override
    public Page<Contact> findAllByStateOrCity(String state, String city, Integer page, Integer q) {
        return contactRepository.findAllByStateOrCity(state,city,new PageRequest(page,q));
    }
}
