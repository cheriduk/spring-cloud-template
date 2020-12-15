package com.gary.ribbon.springcloudribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String sub(@RequestParam Integer a, @RequestParam Integer b) {
        this.loadBalancerClient.choose("USER-SERVER");
        return restTemplate.getForEntity("http://USER-SERVER/add?a=" + a + "&b=" + b, String.class).getBody();

    }

}
