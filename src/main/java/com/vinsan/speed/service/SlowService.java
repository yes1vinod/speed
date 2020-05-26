package com.vinsan.speed.service;

import com.vinsan.speed.bo.HouseBO;
import com.vinsan.speed.util.DataLoad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SlowService {

    @Autowired
    private CommonService commonService;

    public List<HouseBO> processHousingData() {
        DataLoad dataLoad = new DataLoad();
        List<HouseBO> listInputHouseBO = dataLoad.getDataFromCSV();

        Instant startTime = Instant.now();
        List<HouseBO> listOutputHouseBO = listInputHouseBO.stream().map(item -> commonService.findEligibility(item)).collect(Collectors.toList());
        Instant completionTime = Instant.now();
        log.info("Total Time taken --> {}", Duration.between(startTime, completionTime));

        return listOutputHouseBO;
    }
}
