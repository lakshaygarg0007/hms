package com.hotel.bean.manager;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelIdSerialNumber implements Serializable {
    private String hotelId;
    private int serialNumber;
}
