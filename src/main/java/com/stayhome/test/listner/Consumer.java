package com.stayhome.test.listner;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

     @JmsListener(destination = "jmsUserTony.queue")
    public void Listener(String message){
         System.out.println("Recived Message:->" + message);
     }
}
