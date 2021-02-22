package com.hotel.Repository;

import com.hotel.bean.collector.CollectorCollection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CollectorCollectionsRepository extends CrudRepository<CollectorCollection,Integer> {
    @Query(value = "select s from CollectorCollection s where s.requestAccepted=false")
    List<CollectorCollection>findByCollectorId(String collectorId);

    @Query(value = "select s from CollectorCollection s where s.requestAccepted=false")
    List<CollectorCollection>findByApproverId(String approverId);
    @Query(value = "select s from CollectorCollection s where s.requestAccepted=true")
    List<CollectorCollection> findByHotelId(String hotelId);
}
