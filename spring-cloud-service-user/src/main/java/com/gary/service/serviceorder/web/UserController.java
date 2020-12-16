package com.gary.service.serviceorder.web;

import com.gary.service.serviceorder.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
@RequestMapping(value = "users")
public class UserController {

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public String list(@RequestParam String name) throws InterruptedException {
        return name.toUpperCase();
    }

    @RequestMapping(value = "/list2", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public User list2(@RequestBody User user, HttpServletRequest request) throws InterruptedException {
        System.out.println(user.getUsername()+"[==]"+ request.getHeader("X_USERNAME"));
        user.setId(100L);
        user.setUsername(user.getUsername().toUpperCase());
        return user;
    }
}
