package com.gary.hystrix.springcloudhystrix.service.feign;

import com.gary.hystrix.springcloudhystrix.service.fallback.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "USER-SERVER",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

//    @RequestMapping(value = "/hello")
//    public String hello(String name);

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);

    @RequestMapping("/port")
    public String getPort();
}
