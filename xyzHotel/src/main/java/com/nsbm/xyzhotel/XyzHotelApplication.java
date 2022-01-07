package com.nsbm.xyzhotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"xyzhotel.model"})
public class XyzHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyzHotelApplication.class, args);
    }

}
