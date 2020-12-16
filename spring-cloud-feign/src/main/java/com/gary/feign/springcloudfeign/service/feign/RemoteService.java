package com.gary.feign.springcloudfeign.service.feign;

import com.gary.feign.springcloudfeign.model.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface RemoteService {
    // 通过@RequestLine指定HTTP协议及URL地址
    @RequestLine("GET /users/list?name={name}")
    String getOwner(@Param(value = "name") String name);

    // 加入@Headers注解，指定Content-Type为json
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @RequestLine("POST /users/list2")
    User getOwner2(User user);
}
