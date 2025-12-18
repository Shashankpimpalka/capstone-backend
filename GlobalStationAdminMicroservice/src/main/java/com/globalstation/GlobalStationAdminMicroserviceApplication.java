package com.globalstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
public class GlobalStationAdminMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalStationAdminMicroserviceApplication.class, args);
    }

}
