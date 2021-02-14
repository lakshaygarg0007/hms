package com.hotel.bean;

import javafx.scene.control.PasswordField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sun.security.util.Password;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User{

    @Id
    @Column
    private String uname;
    @Column
    private String fname;
    @Column
    private String lname;
    @Column
    private String cnumber;
    @Column
    private String email;
    @Column
    private String passwd;
}