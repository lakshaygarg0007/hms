package com.hotel.Service.approver;

import com.hotel.Repository.ApproverRegistrationRepository;
import com.hotel.bean.approver.approverEntity;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApproverRegistrationVerificationService {
    @Autowired
    ApproverRegistrationRepository approverRegistrationRepository;

    public Pair<String,Boolean> verify(Map<String,String> map)
    {
        approverEntity approverEntity = new approverEntity(map.get("approverId"), map.get("fname"), map.get("lname"), map.get("email"),map.get("cnumber") ,map.get("passwd"));
        approverRegistrationRepository.save(approverEntity);
        return new Pair<>("Registered Successfully You can Login",true);
    }
}
