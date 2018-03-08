package com.exam.apirest.controllers;

import com.exam.apirest.model.Contact;
import com.exam.apirest.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping
    public Contact postContact(@RequestBody @Valid Contact contact){
       return contactService.createContact(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@RequestBody @Valid Contact contact, @PathVariable("id") Integer idContact){
        return contactService.updateContact(contact, idContact);
    }

    @GetMapping("/{id}")
    public Contact getByIdContact(@PathVariable("id") Integer idContact){
        return contactService.findByIdContact(idContact);
    }

    @DeleteMapping("/{id}")
    public Contact deleteContact(@PathVariable("id") Integer idContact){
        return contactService.deleteContact(idContact);
    }

    @GetMapping("/email")
    public Contact getByEmail(@RequestParam(value="email") String email){
        return contactService.findByEmail(email);
    }

    @GetMapping("/address")
    public Page<Contact> getAllByStateOrCity(@RequestParam(value = "state", required = false) String state,
                                             @RequestParam(value = "city", required = false) String city,
                                             @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                             @RequestParam(value = "q", required = false, defaultValue = "10") Integer q){
        return contactService.findAllByStateOrCity(state,city,page,q);
    }

}
