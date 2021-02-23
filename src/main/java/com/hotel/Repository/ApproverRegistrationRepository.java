package com.hotel.Repository;


import com.hotel.bean.approver.approverEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApproverRegistrationRepository extends CrudRepository<approverEntity,String> {
    boolean existsByApproverIdAndPasswd(String approverId,String passwd);
    List<approverEntity> findAll();
}
