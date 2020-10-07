package com.app.service.impl;

import com.app.dao.RoleDao;
import com.app.model.Role;
import com.app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> listRole() {
        return roleDao.findAll();
    }

    @Override
    public Role saveOrUpdateRole(Role role) {
        if (role.getRoleName() == null) {
            throw new IllegalArgumentException("Role is required.");
        }

        roleDao.findByRoleName(role.getRoleName()).ifPresent(e -> {
            throw new IllegalArgumentException("Existed role");
        });
        return roleDao.save(role);
    }
}
