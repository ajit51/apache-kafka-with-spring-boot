package com.apachekafkawithspringboot.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apachekafkawithspringboot.payload.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	@KafkaListener(topics = "test_topic", groupId = "myGroup")
	public void consumeMsg(String msg) {
		log.info(String.format("Consuming the message from test_topic topic:: %s", msg));

	}

	@KafkaListener(topics = "test_topic", groupId = "myGroup")
	public void consumeJsonMsg(Student student) {
		log.info(String.format("Consuming the message from test_topic topic:: %s", student.toString()));

	}

}
