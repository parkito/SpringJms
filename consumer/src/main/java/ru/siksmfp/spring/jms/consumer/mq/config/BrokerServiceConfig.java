package ru.siksmfp.spring.jms.consumer.mq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Artem Karnov @date 5/7/2018.
 * @email artem.karnov@t-systems.com
 */
@Configuration
@EnableJms
public class BrokerServiceConfig {
    @Value("${activemq.broker-url}")
    private String brokerUrl;

    //Set up broker
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setTrustedPackages(Collections.singletonList("ru.siksmfp.spring.jms.dto.entity"));
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        return activeMQConnectionFactory;
    }

    //Set up concurrency listener
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory());
        factory.setConcurrency("3-10");

        return factory;
    }

    //Sending message

    //Connection pooling
    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        return new CachingConnectionFactory(activeMQConnectionFactory());
    }
}
