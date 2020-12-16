package com.gary.hystrix.springcloudhystrix.web;

import com.gary.hystrix.springcloudhystrix.service.feign.HelloRemote;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String sub(@RequestParam Integer a, @RequestParam Integer b) {
        this.loadBalancerClient.choose("USER-SERVER");
        return restTemplate.getForEntity("http://USER-SERVER/add?a=" + a + "&b=" + b, String.class).getBody();
    }

    private String getDefaultUser(@RequestParam Integer a, @RequestParam Integer b) {
        System.out.println("熔断，默认回调函数");
        return "{\"username\":\"admin\",\"age\":\"-1\"}";
    }
}
