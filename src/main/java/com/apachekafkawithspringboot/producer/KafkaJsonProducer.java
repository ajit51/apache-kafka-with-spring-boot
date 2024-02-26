package com.apachekafkawithspringboot.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RestController;

import com.apachekafkawithspringboot.payload.Student;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class KafkaJsonProducer {

	private final KafkaTemplate<String, Student> kafkaTemplate;
	private static final String TOPIC = "test_topic";

	public void sendMessagee(Student student) {
		Message<Student> message = MessageBuilder.withPayload(student).setHeader(KafkaHeaders.TOPIC, TOPIC).build();

		kafkaTemplate.send(message);
	}

}
