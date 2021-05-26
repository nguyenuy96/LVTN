package com.app.service.impl;

import com.app.dao.AccountDao;
import com.app.dao.ContactDao;
import com.app.dto.ContactReq;
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
                .orElseThrow(() -> new IllegalArgumentException("Non-existed contact"));
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDao.findAll();
    }

    @Override
    public Contact updateContact(Contact request) {
        Contact contact = contactDao.findById(request.getContactId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee"));
        contact.setContact(request.getName() != null ? request.getName() : contact.getName(),
                request.getGender() != null ? request.getGender() : contact.getGender(),
                request.getPhoneNumber() != null ? request.getPhoneNumber() : contact.getPhoneNumber(),
                request.getNationality() != null ? request.getNationality() : contact.getNationality(),
                request.getIdentification() != null ? request.getIdentification() : contact.getIdentification(),
                request.getAddress() != null ? request.getAddress() : contact.getAddress());
        return contactDao.save(contact);
    }

    @Override
    public void saveContact(ContactReq request) {
        Account account = accountDao.findById(request.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Not found user with id = [%d]", request.getAccountId())));
        Contact contact = new Contact();
        contact.setContact(request.getName(), request.getGender(), request.getPhoneNumber(),
                request.getNationality(), request.getIdentification(), request.getAddress());
        account.setContact(contact);
        accountDao.save(account);
    }
}
