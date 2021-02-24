package com.hotel.Repository;

import com.hotel.bean.collector.collectorHotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectorHotelRepository extends CrudRepository<collectorHotel,String> {
    List<collectorHotel> findByCollectorID(String collectorId);
}
