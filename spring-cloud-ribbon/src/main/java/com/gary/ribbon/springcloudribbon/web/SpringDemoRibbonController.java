package com.gary.ribbon.springcloudribbon.web;


import com.gary.ribbon.springcloudribbon.service.SpringDemoRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringDemoRibbonController {

    @Autowired
    SpringDemoRibbonService springDemoRibbonService;

    @RequestMapping("/hello")
    public String port() {
        System.out.println("into=========[port]=> ");
        return springDemoRibbonService.port();
    }

}
