package com.endie.avizandum.world.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {

    @Value("${tester2}")
    private String testValue = "";

    @RequestMapping("/test")
    public String home() {
        System.out.println("testValue: " + testValue);

        return "testValue " + testValue;
    }
}
