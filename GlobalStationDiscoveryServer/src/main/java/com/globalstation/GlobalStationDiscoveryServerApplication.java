package com.globalstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GlobalStationDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalStationDiscoveryServerApplication.class, args);
    }

}
