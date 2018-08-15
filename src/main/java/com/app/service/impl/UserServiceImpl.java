package com.app.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.service.UserSERVICE;
@Service
@Transactional(propagation = Propagation.SUPPORTS ,readOnly=true)
public class UserServiceImpl implements UserSERVICE{

}
