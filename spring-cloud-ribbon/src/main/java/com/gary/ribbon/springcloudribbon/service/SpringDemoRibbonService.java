package com.gary.ribbon.springcloudribbon.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpringDemoRibbonService {

    @Autowired
    RestTemplate restTemplate;

    public String port() {
        return restTemplate.getForObject("http://USER-SERVER/port", String.class);
    }


}
