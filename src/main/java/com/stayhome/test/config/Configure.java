package com.stayhome.test.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@EnableJms
@Configuration
public class Configure {
    @Value("tcp://localhost:61616")
     private  String brokerUrl;

    @Bean
    public Queue queue(){
        return  new ActiveMQQueue("jmsUserTony.queue");
    }
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory factory= new ActiveMQConnectionFactory();
          factory.setBrokerURL(brokerUrl);
          return  factory;
    }
    @Bean
    public JmsTemplate jmsTemplate(){
        return  new JmsTemplate(activeMQConnectionFactory());
    }


}
