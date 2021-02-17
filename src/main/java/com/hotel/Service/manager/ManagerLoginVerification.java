package com.hotel.Service.manager;


import com.hotel.Repository.ManagerRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ManagerLoginVerification {
    @Autowired
    ManagerRegistrationRepository managerRegistrationRepository;
    public boolean verifyAtLogin(String hotelId, String passwd){
      return managerRegistrationRepository.existsByHotelIdAndPasswd(hotelId, passwd);
    }
}
