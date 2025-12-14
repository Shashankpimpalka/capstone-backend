package com.globalstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GlobalStationActorsMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalStationActorsMicroserviceApplication.class, args);
    }

}
