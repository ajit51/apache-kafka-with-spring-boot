package com.apachekafkawithspringboot.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private static final String TOPIC = "test_topic";

	public void sendMessage(String msg) {
		log.info(String.format("sending message to test_topic topic::%s", msg));
		kafkaTemplate.send(TOPIC, msg);
	}

}
