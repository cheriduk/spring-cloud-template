package com.gary.feign.springcloudfeign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 认证信息
 * 在配置类中使用Feign.builder().requestInterceptor()方法，
 * 该方法需要一个实现了RequestInterceptor接口的对象，
 * 该接口的apply方法会带有RequestTemplate参数，
 * 通过RequestTemplate参数对象的header方法即动态设置header
 */
public class MyRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header("X_USERNAME", "scott");
    }
}
