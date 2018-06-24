package com.ngls.web.customer.controller;


import com.ngls.user.domain.UserDemo;
import com.ngls.user.service.UserDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo-user")
public class DemoUserController {


    @Autowired
    private UserDemoService userDemoService;

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public UserDemo find(@RequestParam("id") Long id) {
        return userDemoService.find(id);
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public Long insert(@RequestParam("id") Long id) {
        UserDemo demo = new UserDemo();
        demo.setName("ngls" + id);
        demo.setAge(id.intValue());
        return userDemoService.insert(demo);
    }

}
