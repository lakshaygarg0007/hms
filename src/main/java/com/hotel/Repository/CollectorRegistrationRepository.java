package com.hotel.Repository;


import com.hotel.bean.collector.CollectorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectorRegistrationRepository extends CrudRepository<CollectorEntity,String > {
    List<CollectorEntity> findAll();

}
