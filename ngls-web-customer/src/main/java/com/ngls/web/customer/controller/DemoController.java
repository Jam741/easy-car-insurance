package com.ngls.web.customer.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deom")
public class DemoController {


    @GetMapping("demo")
    public String demo() {
        return "helko";
    }

}
