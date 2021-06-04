package com.app.dto;

import com.app.model.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ResponseAccount {
    private String userName;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private String roleName;
    private ResponseContact contact;
    private boolean isActive;

    public void convertAccount2ResponseAccount(Account account) {
        this.contact = new ResponseContact();
        this.contact.convertContact2ResponseContact(account.getContact());
        this.userName = account.getUserName();
        if (null != account.getRole()) {
            this.roleName = account.getRole().getRoleName();
        }
        this.isActive = account.isActive();
        this.createdBy = account.getCreateBy();
        this.createdDate = account.getCreateDate();
        this.modifiedBy = account.getModifyBy();
        this.modifiedDate = account.getUpdateDate();
    }
}
