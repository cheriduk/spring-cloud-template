package com.gary.service.serviceorder.web;

import com.gary.service.serviceorder.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestServiceProvider {
    @Value("${server.port}")
    private String port;
    @Value("${spring.cloud.client.ipAddress}")
    private String ipAddress;

    /**
     * @param name
     * @return Person
     * @Description: post接口
     */
    @RequestMapping(value = "/demo/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Person postPerson(@RequestParam("name") String name) {
        Person person = new Person();
        person.setName(name);
        person.setAge("10");
        person.setSex("man");
        return person;
    }

    /**
     * @param person
     * @return Person
     * @Description: post接口
     */
    @RequestMapping(value = "/body/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Person postPerson(@RequestBody Person person) {
        person.setAge("10");
        person.setSex("man");
        return person;
    }

    /**
     * @param name
     * @return String
     * @Description: get接口
     */
    @GetMapping(value = "/demo/getHost/{name}")
    public String getHost(@PathVariable String name) {
        return "hi, " + name + "! i from " + ipAddress + ":" + port;
    }

    /**
     * @param name
     * @param age
     * @return String
     * @Description: get接口, 包含header信息
     */
    @RequestMapping(value = "/head/getHost", method = RequestMethod.GET)
    public String getHost(@RequestParam("name") String name, @RequestHeader Integer age) {
        return "hi, " + name + ", your age is " + age + "! i from " + ipAddress + ":" + port;
    }
}
