package com.hotel.Service;


import com.hotel.Repository.ApproverRegistrationRepository;
import com.hotel.Repository.CollectorRegistrationRepository;
import com.hotel.Repository.ManagerRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class LoginVerificationService {
    @Autowired
    ManagerRegistrationRepository managerRegistrationRepository;
    @Autowired
    CollectorRegistrationRepository collectorRegistrationRepository;
    @Autowired
    ApproverRegistrationRepository approverRegistrationRepository;

    public boolean verifyAtLogin(String role,String userId, String passwd){
        if(role.equals("Manager")){
           return managerRegistrationRepository.existsByHotelIdAndPasswd(userId,passwd);
        }
        else if(role.equals("Collector"))
            return collectorRegistrationRepository.existsByCollectorIdAndPasswd(userId,passwd);
        else
            return approverRegistrationRepository.existsByApproverIdAndPasswd(userId,passwd);
    }
}
