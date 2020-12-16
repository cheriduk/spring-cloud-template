package com.gary.feign.springcloudfeign.web;

import com.gary.feign.springcloudfeign.interceptor.MyRequestInterceptor;
import com.gary.feign.springcloudfeign.model.User;
import com.gary.feign.springcloudfeign.service.feign.RemoteService;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果采用httpclient或者okhttp这样相对较重的框架，
 * 对初学者来说编码量与学习曲线都会是一个挑战，而使用spring中RestTemplate，
 * 又没有配置化的解决方案，由此想到是否可以脱离spring cloud，独立使用Feign
 */

public class NameRemoteCall {
    public static void main(String[] args) {
//        RemoteService service = Feign.builder()
//                .options(new Request.Options(1000, 3500))
//                .retryer(new Retryer.Default(5000, 5000, 3))
//                .target(RemoteService.class, "http://127.0.0.1:8091");
//        // 与调用本地方法相同的方式调用feign包装的接口，直接获取远程服务提供的返回值
//        String result = service.getOwner("scott");
//        System.out.println(result);

//        RemoteService service = Feign.builder()
//                .encoder(new JacksonEncoder())
//                .decoder(new JacksonDecoder())
//                .options(new Request.Options(1000, 3500))
//                .retryer(new Retryer.Default(5000, 5000, 3))
//                .target(RemoteService.class, "http://127.0.0.1:8091");
//
//        User u = new User();
//        u.setId(12L);
//        u.setUsername("duke");
//        User result = service.getOwner2(u);
//        System.out.println(result);

        User u = new User();
        u.setId(12L);
        u.setUsername("duke");
        RemoteService service = Feign.builder()
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .requestInterceptor(new MyRequestInterceptor()).encoder(new SpringEncoder(feignHttpMessageConverter()))
                .decoder(new SpringDecoder(feignHttpMessageConverter()))
                .target(RemoteService.class, "http://127.0.0.1:8091");
        System.out.println(service.getOwner2(u));
    }

    public static ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
        final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(new GateWayMappingJackson2HttpMessageConverter());
        return () -> httpMessageConverters;
    }

    public static class GateWayMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
        GateWayMappingJackson2HttpMessageConverter() {
            List<MediaType> mediaTypes = new ArrayList<>();
            mediaTypes.add(MediaType.valueOf(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));
            setSupportedMediaTypes(mediaTypes);
        }
    }

}
