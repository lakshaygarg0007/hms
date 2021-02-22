package com.hotel.bean.approver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sun.security.x509.SerialNumber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class approverRequests{
    @Id @GeneratedValue
    private int serialNumber;
    @Column
    String hotelId;
    @Column
    String approverId;
    @Column
    Double amount;
    @Column
    Boolean requestAccepted;

    public approverRequests(String hotelId,Double amount,Boolean requestAccepted)
    {
        this.hotelId=hotelId;
        this.amount=amount;
        this.requestAccepted=requestAccepted;
    }

}
