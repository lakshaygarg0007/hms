package com.hotel;

import com.hotel.Repository.CollectorManagerRepository;
import com.hotel.Repository.CollectorRegistrationRepository;
import com.hotel.bean.collector.CollectorEntity;
import javafx.util.Pair;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
@NoArgsConstructor

/*class Compare implements Comparator<Pair<Integer,String>> {
    @Override
    public int compare(Pair<Integer, String> o1, Pair<Integer, String> o2) {
        if(o1.getKey()<o2.getKey())
            return 1;
        return 0;
    }
}*/
@Service
public class AtStarting {
    @Autowired
    CollectorRegistrationRepository collectorRegistrationRepository;

    @Autowired
    CollectorManagerRepository collectorManagerRepository;
   /* Compare compare=new Compare();*/
    public static PriorityQueue<Pair<Integer, String>> q=new PriorityQueue<Pair<Integer, String>>();

    List<CollectorEntity> collectorEntityList=collectorRegistrationRepository.findAll();

    void job(){
        for(int i=0;i<collectorEntityList.size();i++){
            String collectorId=collectorEntityList.get(i).getCollectorId();
            int hotelAssigned=collectorManagerRepository.findByCollectorID(collectorId).size();
            q.add(new Pair<>(hotelAssigned,collectorId));
        }
    }


}
