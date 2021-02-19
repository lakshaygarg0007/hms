package com.hotel.Repository;

import com.hotel.bean.collector.collectorHotel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CollectorManagerRepository extends CrudRepository<collectorHotel,String> {
    List<collectorHotel> findByCollectorID(String collectorId);
}
