package com.elroykanye.producer.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record SimpleMessageDto(
    UUID id,
    String content,
    LocalDateTime createdAt,
    LocalDateTime respondedAt
) {
    public SimpleMessageDto(String content) {
        this(UUID.randomUUID(), content, LocalDateTime.now(), null);
    }

    public String correlationId() {
        return String.valueOf(hashCode());
    }
}
