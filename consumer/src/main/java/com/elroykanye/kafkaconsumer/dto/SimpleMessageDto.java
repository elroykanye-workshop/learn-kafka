package com.elroykanye.kafkaconsumer.dto;

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
    public String correlationId() {
        return String.valueOf(hashCode());
    }
}
