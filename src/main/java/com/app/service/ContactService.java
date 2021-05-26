package com.app.service;

import com.app.dto.ContactReq;
import com.app.model.Contact;

import java.util.List;

public interface ContactService {
    Contact getContact(String userName);
    List<Contact> getAllContacts();
    Contact updateContact(Contact request);
    void saveContact(ContactReq request);
}
