package com.hotel.bean.manager;


import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ManagerTranscation {

    @Id
    String hotelId;
    @Column
    Double newamount;
    @Column
    Date date;
}
