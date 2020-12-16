package com.gary.config.springcloudconfigclientstatic.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Value("${foo: localhost}")
    String foo;

    @RequestMapping("/foo")
    public String hi(){
        return foo;
    }
}
