package com.vinsan.speed.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.vinsan.speed.bo.HouseBO;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
public class DataLoad {


    public List getDataFromCSV() {
        try {

            log.info("Get Data from CSV ..");

            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource("housing.csv").getFile();
            MappingIterator<HouseBO> readValues =
                    mapper.readerFor(HouseBO.class).with(bootstrapSchema).readValues(file);
            return readValues.readAll();

        } catch (IOException ioex) {
            log.error("Exception ", ioex);

            return null;
        }

    }
}
