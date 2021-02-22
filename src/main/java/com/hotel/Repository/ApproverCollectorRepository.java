package com.hotel.Repository;

import com.hotel.bean.approver.approverCollector;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ApproverCollectorRepository extends CrudRepository<approverCollector,String> {
    List<approverCollector> findByApproverId(String approverId);
    List<approverCollector> findByCollectorId(String collectorId);
}
