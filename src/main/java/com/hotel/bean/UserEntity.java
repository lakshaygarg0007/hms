package com.hotel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserEntity")
public class UserEntity {
    @Id
    String userId;
    @Column
    String password;
}
