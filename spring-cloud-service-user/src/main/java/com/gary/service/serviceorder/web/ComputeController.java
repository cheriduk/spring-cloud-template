package com.gary.service.serviceorder.web;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@RestController
public class ComputeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        int r = a + b;
        System.err.println("user - "+port);
        return "From Service-A, Result is " + r + "\nPort:" + port;
    }

    //call service-B
    @RequestMapping(value = "testServiceB", method = RequestMethod.GET)
    public String testServiceB(@RequestParam Integer a, @RequestParam Integer b) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8092/sub?a=" + a + "&b=" + b, String.class);
    }


}

