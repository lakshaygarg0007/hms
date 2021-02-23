package com.hotel.Service.approver;

import com.hotel.Repository.ApproverCollectorRepository;
import com.hotel.Repository.CollectorCollectionsRepository;
import com.hotel.Repository.CollectorHotelRepository;
import com.hotel.bean.approver.approverCollector;
import com.hotel.bean.collector.CollectorCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Service
public class ApproverDashboardService {
    @Autowired
    CollectorHotelRepository collectorHotelRepository;
    @Autowired
    CollectorCollectionsRepository collectorCollectionsRepository;
    @Autowired
    ApproverCollectorRepository approverCollectorRepository;
    public List<CollectorCollection> showRequest(String approverId){
        System.out.println(approverId);
       return collectorCollectionsRepository.findByApproverId(approverId);
    }

    public void acceptRequest(@RequestParam(value = "approverId")String approverId,@RequestParam(value = "collectorId")String collectorId,@RequestParam(value = "amount")Double amount){
        String hotelId=collectorCollectionsRepository.findByApproverIdAndCollectorId(approverId,collectorId).get(0).getHotelId();
        CollectorCollection obj=new CollectorCollection(hotelId,collectorId,approverId,amount,true);
        collectorCollectionsRepository.save(obj);
    }


}
