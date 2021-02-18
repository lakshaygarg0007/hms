package com.hotel.Repository;

import com.hotel.bean.manager.ManagerTranscation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface    ManagerTranscationRepository extends CrudRepository<ManagerTranscation,String> {
    List<ManagerTranscation> findByHotelIdAndDate(String hotelId, Date date);
    List<ManagerTranscation> findByDateBetween(Date starting,Date ending);

}
