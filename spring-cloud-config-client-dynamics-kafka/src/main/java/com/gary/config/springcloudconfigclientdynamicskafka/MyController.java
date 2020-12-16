package com.gary.config.springcloudconfigclientdynamicskafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MyController {

    @Value("${foo: localhost}")
    String foo;

    @RequestMapping("/foo")
    public String hi(){
        return foo;
    }
}
