package com.stayhome.test.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/rest")
public class ProducerResource {
    @Autowired
    private Queue queue;
    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("publish/{message}")
    public String publish(@PathVariable("message") final String message){
        jmsTemplate.convertAndSend(queue,message);
        return "Published is Successfully";
    }
}
