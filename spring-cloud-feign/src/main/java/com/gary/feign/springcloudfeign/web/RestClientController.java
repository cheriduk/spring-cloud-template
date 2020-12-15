package com.gary.feign.springcloudfeign.web;

import com.gary.feign.springcloudfeign.model.Person;
import com.gary.feign.springcloudfeign.service.HelloServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestClientController {

    @Autowired
    private HelloServiceFeign client;

    /**
     * @param name
     * @return Person
     * @Description: 测试服务提供者post接口
     */
    @RequestMapping(value = "/client/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Person postPerson(String name) {
        return client.postPerson(name);
    }

    /**
     * @param name
     * @return String
     * @Description: 测试服务提供者get接口
     */
    @GetMapping(value = "/client/getHost/{name}")
    public String getHost(@PathVariable String name) {
        return client.getHost(name);
    }

    @RequestMapping(value = "/client/port")
    public String getPort() {
        return client.getPort();
    }
}
