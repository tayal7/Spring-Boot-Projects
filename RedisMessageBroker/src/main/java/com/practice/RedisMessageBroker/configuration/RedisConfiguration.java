package com.practice.RedisMessageBroker.configuration;

import com.practice.RedisMessageBroker.receiver.RedisReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import java.util.UUID;
import java.util.concurrent.Executors;

@Configuration
public class RedisConfiguration {

    @Bean
    JedisConnectionFactory connectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();  //----- it provides better connection properties
        return factory;
    }

    @Bean
    public RedisTemplate<String,String> redisTemplate(){    //----- provides high level abstraction to redis interactions
            RedisTemplate<String,String> template = new RedisTemplate<>();
            template.setConnectionFactory(connectionFactory());
            template.setValueSerializer(new GenericToStringSerializer<String>(String.class));
            return template;
    }

    @Bean
    ChannelTopic topic(){ //------ random generated name(/topic) given to carry message through channel
        return new ChannelTopic(UUID.randomUUID().toString());
    }

    @Bean
    RedisMessageListenerContainer redisMessageListenerContainer(){ //----- listener for receiver
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.addMessageListener(new MessageListenerAdapter(new RedisReceiver()),topic());  //----- mapping of topic to receiver class
        container.setTaskExecutor(Executors.newFixedThreadPool(4));
        return container;
    }

}
