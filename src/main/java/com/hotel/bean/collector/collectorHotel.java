package com.hotel.bean.collector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class collectorHotel {
    @Column
    String collectorID;
    @Id
    String hotelId;
}
