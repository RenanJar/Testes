package com.notification.notification.service;

import com.notification.notification.dto.NotificationNewCarDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ClientService {

    @Value("#{'${list.Webhook}'.split(',')}")
    List<String> listWebhook;

    public NotificationNewCarDTO postNotificationToClient(String url, NotificationNewCarDTO notification){
        RestTemplate restTemplate= new RestTemplate();

        NotificationNewCarDTO request= restTemplate.postForObject(url,notification, NotificationNewCarDTO.class);

        return request;
    }

}
