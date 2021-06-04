package com.app.service.impl;


import com.app.dao.AccountDao;
import com.app.dao.ContactDao;
import com.app.dao.RoleDao;
import com.app.dto.*;
import com.app.model.Account;
import com.app.model.Contact;
import com.app.model.Role;
import com.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private ContactDao contactDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void addNewUser(CreatedAccount request) {
        accountDao.findByUserName(request.getUserName()).ifPresent(e -> {
            throw new IllegalArgumentException("Existed user");
        });
        Account account = new Account();
        account.setUserName(request.getUserName());
        account.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        account.setRole(getRole(request.getRoleName()));
        accountDao.save(account);
    }

    @Override
    public void changePassword(ModifiedPassword modifiedPassword) {
        Account modifiedAccount = accountDao.findByUserName(modifiedPassword.getUserName())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user"));
        if (!bCryptPasswordEncoder.matches(modifiedPassword.getOldPassword(), modifiedAccount.getPassword())) {
            throw new IllegalArgumentException("Incorrect old password");
        }

        if (!modifiedPassword.getNewPassword().equals(modifiedPassword.getRetypePassword())) {
            throw new IllegalArgumentException("New password and re-type are not matched");
        }
        modifiedAccount.setPassword(bCryptPasswordEncoder.encode(modifiedPassword.getNewPassword()));
        accountDao.save(modifiedAccount);
    }

    @Override
    public ResponseAccount getAccountByUsername(String userName) {
        Account account = accountDao.findByUserName(userName)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Not found user [%s]", userName)));
        ResponseAccount responseAccount = new ResponseAccount();
        responseAccount.convertAccount2ResponseAccount(account);
        return responseAccount;
    }

    @Override
    public List<ResponseAccount> findAllAccounts() {
        List<Account> accountList = accountDao.findAll();
        return accountList.stream().map(account -> {
            ResponseAccount responseAccount = new ResponseAccount();
            responseAccount.convertAccount2ResponseAccount(account);
            return responseAccount;
        }).collect(Collectors.toList());
    }

    @Override
    public void disableAccount(Long id) {
        Account account = accountDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Not found user with id [%d]", id)));
        account.setActive(false);
        accountDao.save(account);
    }

    private Role getRole(String roleName) {
        return roleDao.findByRoleName(roleName).orElseThrow(() -> new IllegalArgumentException(
                String.format("Role = [%s] not found", roleName)));
    }
}
