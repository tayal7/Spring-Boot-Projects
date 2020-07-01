package com.practice.RedisMessageBroker.controller;

import com.practice.RedisMessageBroker.sender.RedisSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RedisController {

    @Autowired
    private RedisSender sender;

    @GetMapping("/redis")
    public String sendDataToRedisQueue(@RequestParam("redis") String input) {
        //----- http://localhost:8080/redis?redis=writtenmessage
        sender.sendMessage(input);
        return "Message successfully sent";
    }
}