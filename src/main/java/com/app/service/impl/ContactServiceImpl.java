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
        Account employeeAccount = accountDao.findByUserName(userName)
                .orElseThrow(() -> new IllegalArgumentException("Non-existed User"));
        return contactDao.findById(employeeAccount.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Non-existed employee"));
    }

    @Override
    public List<Contact> getAllContact() {
        return contactDao.findAll();
    }

    @Override
    public Contact updateContact(Contact request) {
        Contact contact = contactDao.findById(request.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee"));
        contact.setAddress(request.getAddress());
        contact.setName(request.getName());
        contact.setPhoneNumber(request.getPhoneNumber());
        contact.setGender(request.getGender());
        contact.setIdentification(request.getIdentification());
        contact.setNationality(request.getNationality());
        return contactDao.save(contact);
    }
}
