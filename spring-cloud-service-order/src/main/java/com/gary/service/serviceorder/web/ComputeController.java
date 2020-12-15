package com.gary.service.serviceorder.web;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class ComputeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    public String sub(@RequestParam Integer a, @RequestParam Integer b) {
        int r = a - b;
        return "From Service-B, Result is " + r + " \nPort:" + port;
    }

    //call service-A
    @RequestMapping(value = "testServiceA", method = RequestMethod.GET)
    public String testServiceB(@RequestParam Integer a, @RequestParam Integer b) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8091/add?a=" + a + "&b=" + b, String.class);
    }
}

