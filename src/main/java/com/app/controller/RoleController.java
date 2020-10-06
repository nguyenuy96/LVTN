package com.app.controller;

import com.app.model.Role;
import com.app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getPermission() {
        return new ResponseEntity<>(roleService.listRole(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Role> savePermission(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.saveOrUpdateRole(role), HttpStatus.CREATED);
    }
}
