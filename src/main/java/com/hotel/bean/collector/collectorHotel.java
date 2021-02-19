package com.hotel.bean.collector;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class collectorHotel {
    @Column
    String collectorID;
    @Id
    String hotelId;
}
