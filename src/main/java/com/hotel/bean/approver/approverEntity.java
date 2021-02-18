package com.hotel.bean.approver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class approverEntity {

    @Id
    String approverId;
    @Column
    private String fname;
    @Column
    private String lname;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String cnumber;
    @Column
    private String passwd;
}
