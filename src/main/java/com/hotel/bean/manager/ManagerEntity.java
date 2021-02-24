package com.hotel.bean.manager;

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


@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ManagerEntity {

    @Id
    private String hotelId;
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