package com.apachekafkawithspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apachekafkawithspringboot.producer.KafkaProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

	private final KafkaProducer kafkaProducer;

	@PostMapping
	public ResponseEntity<String> sendMessage(@RequestBody String message) {
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message Queued Successfully...");
	}

}
