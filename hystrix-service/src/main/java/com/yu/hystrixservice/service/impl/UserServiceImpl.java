package com.yu.hystrixservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yu.hystrixservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @Override
    @HystrixCommand(fallbackMethod = "getDefaultUser")
    public String getUser(Long id) {
        log.info(userServiceUrl);
        return restTemplate.getForObject(userServiceUrl + "/user/find?id={1}", String.class, id);
    }

    public String getDefaultUser(Long id) {
        log.info("系统降级");
        return "降级id" + id;
    }
}
