package com.hotel.bean.collector;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CollectorCollection {
    @Id
    @GeneratedValue
    int serialNumber;
    @Column
    String hotelId;
    @Column
    String collectorId;
    @Column
    String approverId;
    @Column
    Double amount;
    @Column
    Boolean requestAccepted;

    public CollectorCollection(String hotelId,String collectorId,String approverId,Double amount,Boolean requestAccepted){
        this.hotelId=hotelId;
        this.collectorId=collectorId;
        this.approverId=approverId;
        this.amount=amount;
        this.requestAccepted=requestAccepted;
    }



}
