package com.hotel.bean;

import javax.persistence.Column;

public class SubUserEntity {
    @Column
    private String fname;
    @Column
    private String lname;
    @Column
    private String email;
    @Column
    private String cnumber;
    @Column
    private String passwd;
}
