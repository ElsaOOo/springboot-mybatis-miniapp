package com.yezi.demoa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yezi
 * @Date: 2019/4/8 21 23
 * @Description:
 */
@RestController
public class hello {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "hello springboot";
    }
}
