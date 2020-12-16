package com.gary.hystrix.springcloudhystrix.web;

import com.gary.hystrix.springcloudhystrix.service.feign.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloRemote helloRemote;

    @GetMapping("/sayHello")
    public String sayHello(String name){
        System.out.println("name=>"+name);
        return helloRemote.hello(name);
    }

    @GetMapping("/sayPort")
    public String sayPort(String name){
        return helloRemote.getPort();
    }
}
