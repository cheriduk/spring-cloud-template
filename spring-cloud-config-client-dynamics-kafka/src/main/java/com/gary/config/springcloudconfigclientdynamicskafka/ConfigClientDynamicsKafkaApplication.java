package com.gary.config.springcloudconfigclientdynamicskafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientDynamicsKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientDynamicsKafkaApplication.class, args);
    }

}
