package com.app.service.impl;

import com.app.dao.AccountDao;
import com.app.dao.ContactDao;
import com.app.model.Account;
import com.app.model.Contact;
import com.app.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private ContactDao contactDao;

    @Override
    public Contact getContact(String userName) {
        Account account = accountDao.findByUserName(userName)
                .orElseThrow(() -> new IllegalArgumentException("Non-existed User"));
        return contactDao.findById(account.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Non-existed employee"));
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDao.findAll();
    }

    @Override
    public Contact updateContact(Contact request) {
        Contact contact = contactDao.findById(request.getContactId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee"));
        contact.setAddress(request.getAddress() != null ? request.getAddress() : contact.getAddress());
        contact.setName(request.getName() != null ? request.getName() : contact.getName());
        contact.setPhoneNumber(request.getPhoneNumber() != null ? request.getPhoneNumber() : contact.getPhoneNumber());
        contact.setGender(request.getGender() != null ? request.getGender() : contact.getGender());
        contact.setIdentification(request.getIdentification() != null ? request.getIdentification() : contact.getIdentification());
        contact.setNationality(request.getNationality() != null ? request.getNationality() : contact.getNationality());
        return contactDao.save(contact);
    }

    @Override
    public void saveContact(Contact contact) {
        Account account = accountDao.findById(contact.getAccount().getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Non-existed User"));
        contact.setAccount(account);
        contactDao.save(contact);
    }
}
