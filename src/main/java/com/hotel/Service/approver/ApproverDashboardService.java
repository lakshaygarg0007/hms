package com.hotel.Service.approver;

import com.hotel.Repository.ApproverCollectorRepository;
import com.hotel.Repository.CollectorCollectionsRepository;
import com.hotel.bean.approver.approverCollector;
import com.hotel.bean.collector.CollectorCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApproverDashboardService {
    @Autowired
    CollectorCollectionsRepository collectorCollectionsRepository;
    @Autowired
    ApproverCollectorRepository approverCollectorRepository;
    public List<CollectorCollection> showRequest(String approverId){
       return collectorCollectionsRepository.findByApproverId(approverId);
    }
}
