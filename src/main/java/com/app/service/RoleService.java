package com.app.service;

import com.app.exception.ExceptionHandle;
import com.app.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> listRole();
    Role saveOrUpdateRole(Role role);
    Role getRoleById(Long roleId);
}
