package com.gary.feign.springcloudfeign.service.local;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Qualifier
    public String getName(){
        return "";
    }
}
