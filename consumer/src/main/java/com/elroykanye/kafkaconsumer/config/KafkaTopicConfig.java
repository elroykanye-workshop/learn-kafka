package com.elroykanye.kafkaconsumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaTopicConfig {
    @Bean
    public NewTopic topicSimple() {
        return TopicBuilder.name("SIMPLE").build();
    }

    @Bean
    public NewTopic topicSimpleAsync() {
        return TopicBuilder.name("SIMPLE_ASYNC").build();
    }
}