package com.gary.service.serviceorder.service.feign;

import com.gary.service.serviceorder.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-server")
public interface HelloServiceFeign {

    @GetMapping(value = "/demo/getHost/{name}")
    public String getHost(@PathVariable String name);

//    @PostMapping(value = "/demo/postPerson")
//    public Person postPerson(String name);
    @RequestMapping(value = "/demo/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Person postPerson(@RequestParam("name") String name);

    @RequestMapping("/port")
    public String getPort();
}
