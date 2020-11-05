package com.app.service;

import com.app.model.Contact;

import java.util.List;

public interface ContactService {
    Contact getContact(String userName);
    List<Contact> getAllContact();
    Contact updateContact(Contact request);
}
