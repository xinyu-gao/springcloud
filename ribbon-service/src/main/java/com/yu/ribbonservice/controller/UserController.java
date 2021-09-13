package com.yu.ribbonservice.controller;

import com.yu.ribbonservice.utils.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @GetMapping("/find")
    public String find(@RequestParam("id") Long id) {
        log.info(userServiceUrl);
        return restTemplate.getForObject(userServiceUrl + "/user/find?id={1}", String.class, id);
    }

}
