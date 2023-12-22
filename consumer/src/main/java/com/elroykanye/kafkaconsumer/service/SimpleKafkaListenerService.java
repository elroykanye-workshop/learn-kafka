package com.elroykanye.kafkaconsumer.service;

import com.elroykanye.kafkaconsumer.dto.SimpleMessageDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class SimpleKafkaListenerService {
    @KafkaListener(topics = "SIMPLE", groupId = "group-1", containerFactory = "kafkaListenerContainerFactory")
    public void listenSimple(SimpleMessageDto message) {
        System.out.println(message);
    }

    @KafkaListener(topics = "SIMPLE_ASYNC", groupId = "group-2")
    @SendTo
    public Message<?> messageReturn(
        @Payload SimpleMessageDto message,
        @Header(value = KafkaHeaders.CORRELATION_ID, required = false) byte[] correlation
    ) {
        var res = SimpleMessageDto.builder()
            .content("Hello there, heard you")
            .createdAt(message.createdAt())
            .respondedAt(LocalDateTime.now())
            .id(message.id())
            .build();
        return MessageBuilder.withPayload(res)
            //.setHeader(KafkaHeaders.KEY, message.id().toString())
            .setHeader(KafkaHeaders.CORRELATION_ID, message.correlationId().getBytes(StandardCharsets.UTF_8))
            .build();
    }
}
