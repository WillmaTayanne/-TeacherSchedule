package com.pdist.teacherSchedule.amqp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pdist.teacherSchedule.model.Message;
import com.pdist.teacherSchedule.service.MessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class QueueConsumer {

    @Autowired
    MessageService messageService;

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String message) {
        System.out.println("[.] Mensagem recebida para ser salva");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            Message messageEntity = objectMapper.readValue(message, Message.class);
            messageService.push(messageEntity);
        } catch(Exception e) {
            System.out.println("[.] Erro em mensagem, mensagem recebida: " + message + " | " + e.getMessage());
        }
    }

}