package com.yu.feignservice.service.impl;

import com.yu.feignservice.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceFallback implements UserService {

    @Override
    public String getUser(Long id) {
        return "降级：" + id;
    }

}
