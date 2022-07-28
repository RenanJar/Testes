package com.notification.notification.service;

import com.notification.notification.dto.NotificationNewCarDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NotificationService {

    @Value("#{'${list.Webhook}'.split(',')}")
    List<String> listWebhook;


    @RabbitListener(queues = "QueueNewCar")
    public void listenerNotification(String mensagen){
        System.out.println(mensagen);
        this.triggerNotification(listWebhook,new NotificationNewCarDTO("New Car Registered"));
    }

    public void triggerNotification(List<String> urls, NotificationNewCarDTO notification){
        RestTemplate restTemplate = new RestTemplate();
        urls.stream().forEach(url-> restTemplate.postForEntity(url,notification, NotificationNewCarDTO.class));
    }


}
