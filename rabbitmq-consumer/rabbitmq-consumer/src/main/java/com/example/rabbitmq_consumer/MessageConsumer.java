package com.example.rabbitmq_consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumer {

    // Este método se activa automáticamente cuando hay mensajes en la cola
    @RabbitListener(queues = "my_queue")
    public void receiveMessage(String message) {
        log.info("---------------------------------------------------------");
        log.info(">>>> CONSUMIDOR: Procesando mensaje: {}", message);
        log.info("---------------------------------------------------------");
    }
}