package com.elroykanye.producer.service;

import com.elroykanye.producer.config.KafkaTopicConfig;
import com.elroykanye.producer.dto.SimpleMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
@RequiredArgsConstructor
public class SimpleEventProducerService {
    private final KafkaTemplate<String, SimpleMessageDto> kafkaTemplate;
    private final ReplyingKafkaTemplate<String, SimpleMessageDto, SimpleMessageDto> replyingKafkaTemplate;

    public void sendSimple() {
        kafkaTemplate.send(
            KafkaTopicConfig.Topics.SIMPLE.name(),
            new SimpleMessageDto("Hello Kafka, do nothing.")
        );
    }

    public Object sendSimpleAsync() {
        var simpleMessageDto = new SimpleMessageDto("Hello Kafka, do something");
        var message = new ProducerRecord<>(
            KafkaTopicConfig.Topics.SIMPLE_ASYNC.name(),
            simpleMessageDto.id().toString(),
            simpleMessageDto
        );
        var sendFuture = replyingKafkaTemplate.sendAndReceive(message, Duration.ofMinutes(1));
        sendFuture.thenAccept(res -> log.info("Message sent successfully."))
            .exceptionally(err -> {
                log.error("Error occurred while sending the message: " + err.getMessage());
                return null;
            });
        try {
            return sendFuture.get().value();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
