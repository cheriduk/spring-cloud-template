package com.gary.service.serviceorder.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloServiceProvider {
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name.toUpperCase();
    }
}
