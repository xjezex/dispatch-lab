package com.example.rabbitmq_producer.controller;

import com.example.rabbitmq_producer.service.MessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessagePublisher messagePublisher;

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody String message) {
        messagePublisher.sendMessage(message); // cuerpo del mensaje para el nuestro servicio

        return ResponseEntity.ok("Mensaje encolado con exito en RabbitMQ: " + message); // Respuesta HTTP con el mensaje enviado
    }
}
