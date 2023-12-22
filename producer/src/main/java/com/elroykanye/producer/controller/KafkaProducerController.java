package com.elroykanye.producer.controller;

import com.elroykanye.producer.service.SimpleEventProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/producer")
public class KafkaProducerController {
    private final SimpleEventProducerService service;

    @PutMapping("/simple")
    protected void sendSimple() {
        service.sendSimple();
    }

    @PutMapping("/simple/async")
    protected Object sendSimpleAsync() {
        return service.sendSimpleAsync();
    }
}
