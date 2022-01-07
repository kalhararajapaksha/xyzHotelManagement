package com.nsbm.xyzhotel.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"xyzhotel.model"})
public class XyzHotelUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyzHotelUiApplication.class, args);
    }

}
