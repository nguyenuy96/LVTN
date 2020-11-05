package com.app.controller;

import com.app.model.Contact;
import com.app.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    private ContactService contactService;

    @GetMapping(path = "/{userName}")
    public ResponseEntity<Contact> getEmployee(@PathVariable String userName) {
        return new ResponseEntity<>(contactService.getContact(userName), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllEmployee() {
        return new ResponseEntity<>(contactService.getAllContact(), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Contact> updateEmployee(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.updateContact(contact), HttpStatus.OK);
    }
}
