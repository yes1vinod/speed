package com.vinsan.speed.service;

import com.vinsan.speed.bo.HouseBO;
import com.vinsan.speed.util.DataLoad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReactiveService {
    @Autowired
    private CommonService commonService;

//    public List<HouseBO> processHousingData() {
//
//        WebClient webClient = WebClient.create();
//
//        webClient.get().retrieve(commonService.findEligibilityReactive(null))
//        return listOutputHouseBO;
//    }
}
