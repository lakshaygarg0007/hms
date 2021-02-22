package com.hotel.bean.manager;


import com.sun.javafx.beans.IDProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ManagerTransaction {

    @Id @GeneratedValue
    private int serialNumber;
    @Column
    private String hotelId;
    @Column
    Double transaction;
    @Column
    Date date;
    @Column
    Boolean collectedCash=false;

    public ManagerTransaction(String hotelId,Double transaction,Date date){
        this.hotelId=hotelId;
        this.transaction=transaction;
        this.date=date;
    }
}
