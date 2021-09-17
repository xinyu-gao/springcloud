package com.yu.cloud.controller;

import com.yu.cloud.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/find")
    public String create(@RequestParam("id") Long id) {
        log.info(String.valueOf(id));
        new User("id");
        return "success";
    }

}
