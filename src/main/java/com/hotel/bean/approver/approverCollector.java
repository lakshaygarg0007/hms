package com.hotel.bean.approver;

import javax.persistence.Column;
import javax.persistence.Id;

public class approverCollector {
    @Id
    String collectorId;
    @Column
    String approverId;
}
