package com.vinsan.speed.service;

import com.vinsan.speed.bo.HouseBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

@Slf4j

@Service
public class CommonService {

    public HouseBO findEligibility(HouseBO houseBO) {
        try {
//            log.info("In FindEligibility service House Value>>{}",houseBO.getMedianHouseValue());
            TimeUnit.MILLISECONDS.sleep(1);
            houseBO.setProcessCompleted(true);
            return houseBO;
        } catch (InterruptedException ex) {
            log.error("Exception ", ex);
            return null;
        }
    }

    public Flux<HouseBO> findEligibilityReactive(HouseBO houseBO) {
        return Flux.just(findEligibility(houseBO));
    }
}
