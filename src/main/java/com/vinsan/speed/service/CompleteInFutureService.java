package com.vinsan.speed.service;

import com.vinsan.speed.bo.HouseBO;
import com.vinsan.speed.util.DataLoad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CompleteInFutureService {

    @Autowired
    private CommonService commonService;

//    @Autowired
//    private ThreadPoolExecutor executor;

    /**
     * @return
     */
    public List<HouseBO> processHousingData() {
        DataLoad dataLoad = new DataLoad();
        List<HouseBO> listInputHouseBO = dataLoad.getDataFromCSV();
        Instant startTime = Instant.now();
        List<CompletableFuture<HouseBO>> listOfThreads = listInputHouseBO.stream().map(houseBo -> {
            return processHousingBO(houseBo);
        }).collect(Collectors.toList());
        CompletableFuture.allOf(listOfThreads.toArray(new CompletableFuture[listOfThreads.size()])).join();
        Instant completionTime = Instant.now();
        List<HouseBO> listOutputHouseBO = listOfThreads.stream().map(item -> {
            try {
                return item.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        log.info("Total Time taken --> {}", Duration.between(startTime, completionTime));
        return listOutputHouseBO;
    }

    /**
     * @param houseBo
     * @return
     */
    private CompletableFuture<HouseBO> processHousingBO(HouseBO houseBo) {
        Executor executor = Executors.newFixedThreadPool(100);
//        executor.setCorePoolSize(100);
        CompletableFuture<HouseBO> completableFuture = new CompletableFuture<>();
        return CompletableFuture.supplyAsync(() -> {
            try {
                return commonService.findEligibility(houseBo);

            } catch (Exception ex) {
                log.error("Exception ", ex);
                return null;
            }
        }, executor);


    }
}
