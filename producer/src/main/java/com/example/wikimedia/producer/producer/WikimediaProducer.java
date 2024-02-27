package com.example.wikimedia.producer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaProducer {

	private final Logger logger = LoggerFactory.getLogger(WikimediaProducer.class);

	private final KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String msg) {
		logger.info(String.format("Sending message to alibou Topic:: %s", msg));
		kafkaTemplate.send("wikimedia-stream", msg);
	}

}
