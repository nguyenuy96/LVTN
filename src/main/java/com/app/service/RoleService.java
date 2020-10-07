package com.app.service;

import com.app.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
    List<Role> listRole();
    Role saveOrUpdateRole(Role role);
}
