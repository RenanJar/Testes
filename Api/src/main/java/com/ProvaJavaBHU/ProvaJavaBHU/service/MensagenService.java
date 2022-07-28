package com.ProvaJavaBHU.ProvaJavaBHU.service;

import com.ProvaJavaBHU.ProvaJavaBHU.DTO.MensagenNewCarDTO;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MensagenService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviaMensagem(String nomeFila, String mensagem){
        this.rabbitTemplate.convertAndSend(nomeFila,mensagem);
    }

}
