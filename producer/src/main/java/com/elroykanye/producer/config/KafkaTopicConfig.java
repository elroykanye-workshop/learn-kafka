package com.elroykanye.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic topicSimple() {
        return TopicBuilder.name(Topics.SIMPLE.name())
            .build();
    }

    @Bean
    public NewTopic topicSimpleAsync() {
        return TopicBuilder.name(Topics.SIMPLE_ASYNC.name()).build();
    }

    public enum Topics {
        SIMPLE,
        SIMPLE_ASYNC,
        SIMPLE_ASYNC_RES,
    }
}
