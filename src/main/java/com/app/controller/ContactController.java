package com.app.controller;

import com.app.dto.ContactReq;
import com.app.model.Contact;
import com.app.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping(path = "/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public Contact getContact(@PathVariable String userName) {
        return contactService.getContact(userName);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> findAllContacts() {
        return contactService.getAllContacts();
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Contact updateContact(@RequestBody Contact contact) {
        return contactService.updateContact(contact);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewContact(@RequestBody ContactReq request) {
        contactService.saveContact(request);
    }
}
