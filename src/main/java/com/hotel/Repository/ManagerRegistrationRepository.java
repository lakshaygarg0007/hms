package com.hotel.Repository;
import com.hotel.bean.manager.ManagerEntity;
import com.hotel.bean.manager.ManagerTranscation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRegistrationRepository extends CrudRepository<ManagerEntity,String> {
    List<ManagerEntity> findByHotelIdAndPasswd(String hotelId,String passwd);
    boolean existsByHotelIdAndPasswd(String hotelId,String passwd);
}
