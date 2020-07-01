package com.practice.RedisMessageBroker.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class RedisSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisSender.class);

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private ChannelTopic channelTopic;

    public void sendMessage(String message){
        redisTemplate.convertAndSend(channelTopic.getTopic(),message);
        LOGGER.info("Message: " + message + "and Topic:" + channelTopic.getTopic());
    }

}
