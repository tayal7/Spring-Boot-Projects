package com.practice.RedisMessageBroker.receiver;

import com.practice.RedisMessageBroker.sender.RedisSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisReceiver implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiver.class);

    @Override
    public void onMessage(Message message, byte[] bytes) {
        LOGGER.info("Received message is " + message.toString() + "from Topic: " + new String(bytes));
    }
}
