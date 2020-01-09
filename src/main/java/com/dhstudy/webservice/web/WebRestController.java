package com.dhstudy.webservice.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WebRestController {

    @GetMapping(value="/hello")
    public String hello() {
        return "HelloWorld";
    }
}