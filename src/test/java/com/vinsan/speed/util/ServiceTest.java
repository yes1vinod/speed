package com.vinsan.speed.util;

import com.vinsan.speed.bo.HouseBO;
import com.vinsan.speed.service.CompleteInFutureService;
import com.vinsan.speed.service.ParallelProcessing;
import com.vinsan.speed.service.SlowService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Execution(ExecutionMode.CONCURRENT)
public class ServiceTest {

    @Autowired
    private SlowService slowService;

    @Autowired
    private ParallelProcessing parallelProcessing;

    @Autowired
    private CompleteInFutureService completeInFutureService;

    @Test
    public void testSlowService() {
        List<HouseBO> output = slowService.processHousingData();
        Assertions.assertEquals(true, output.size() > 0);

    }

    @Test
    public void testParallelService() {
        List<HouseBO> output = parallelProcessing.processHousingData();
        Assertions.assertEquals(true, output.size() > 0);

    }

    @Test
    public void testCallableService() {
        List<HouseBO> output = completeInFutureService.processHousingData();
        Assertions.assertEquals(true, output.size() > 0);
    }
}
