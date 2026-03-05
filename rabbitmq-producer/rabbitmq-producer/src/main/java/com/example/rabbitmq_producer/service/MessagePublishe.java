package com.example.rabbitmq_producer.service;

import com.example.rabbitmq_producer.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessagePublishe {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        log.info("Preparando envío de mensaje al broker: {}", message);

        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE,
                RabbitConfig.ROUTING_KEY,
                message
        );

        log.info("Mensaje enviado con exito a traves del exchange: {}", RabbitConfig.EXCHANGE);
    }
}
