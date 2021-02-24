package com.hotel.bean.manager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ManagerExpense {
    @Column
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

