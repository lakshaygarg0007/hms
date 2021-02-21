package com.hotel.bean.manager;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@IdClass(HotelIdSerialNumber.class)
public class ManagerExpense {
    @Id
    private String hotelId;
    @Id @GeneratedValue
    private int serialNumber;
    @Column
    Double expense ;
    @Column
    Date date;

    public ManagerExpense(String hotelId,Double expense,Date date){
        this.hotelId=hotelId;
        this.expense=expense;
        this.date=date;
    }
}

