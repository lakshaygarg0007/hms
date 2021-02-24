package com.hotel.Repository;

import com.hotel.bean.approver.approverRequests;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApproverRequestsRepository extends CrudRepository<approverRequests,Integer> {
    @Query(value="Select s from approverRequests s where s.requestAccepted=false")
    List<approverRequests> findByApproverId(String approverId);
}
