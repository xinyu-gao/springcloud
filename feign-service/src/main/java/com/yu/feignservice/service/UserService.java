package com.yu.feignservice.service;

import com.yu.feignservice.service.impl.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ribbon-service", fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/user/find")
    String getUser(@RequestParam("id") Long id);
}
