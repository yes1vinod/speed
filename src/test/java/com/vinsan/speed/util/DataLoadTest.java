package com.vinsan.speed.util;

import com.vinsan.speed.bo.HouseBO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@Slf4j
@SpringJUnitConfig
public class DataLoadTest {

    @Test
    public void getDataFromCSV() {
        DataLoad dataLoad = new DataLoad();
        List<HouseBO> housingBOList = dataLoad.getDataFromCSV();
        log.debug("List size in testing >> {}", housingBOList.size());
        Assertions.assertEquals(true, housingBOList.size() > 0);
    }


}

