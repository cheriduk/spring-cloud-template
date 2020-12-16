package com.gary.hystrix.springcloudhystrix.service.fallback;

import com.gary.hystrix.springcloudhystrix.service.feign.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloRemoteHystrix  implements HelloRemote{

    @Override
    public String hello(String name) {
        return "hello=>" +name+", this messge send failed ";
    }

    @Override
    public String getPort() {
        return "hello" +00+", this messge send failed ";
    }
}

