package com.vinsan.speed;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpeedApplication {

    public static void main(String[] args) {
        log.info(":::::::Starting Spring Boot Application :::::SPEED::::");
        SpringApplication.run(SpeedApplication.class, args);
    }

}
