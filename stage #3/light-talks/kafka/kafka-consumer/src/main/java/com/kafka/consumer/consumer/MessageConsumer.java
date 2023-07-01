package com.kafka.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumer {
	@KafkaListener(topics = "messages")
	public void listenGroupOne(String message) {
		log.info("Received Message in topic messages: " + message);
	}

}
