package com.app.dto;

import com.app.model.Contact;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseContact {
    private String name;

    private String gender;

    private String phoneNumber;

    private String nationality;

    private String identification;

    private String address;

    public void convertContact2ResponseContact(Contact contact) {
        if (contact != null) {
            this.name = contact.getName();
            this.gender = contact.getGender();
            this.phoneNumber = contact.getPhoneNumber();
            this.nationality = contact.getNationality();
            this.identification = contact.getIdentification();
            this.address = contact.getAddress();
        }
    }
}
