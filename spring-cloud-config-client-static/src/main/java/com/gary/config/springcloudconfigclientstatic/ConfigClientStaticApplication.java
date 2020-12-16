package com.gary.config.springcloudconfigclientstatic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
public class ConfigClientStaticApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientStaticApplication.class, args);
    }

}
