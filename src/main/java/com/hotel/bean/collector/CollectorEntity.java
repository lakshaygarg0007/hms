package com.hotel.bean.collector;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class CollectorEntity {
    @Id
    private String collectorId;
    @Column
    private String approverId;
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
