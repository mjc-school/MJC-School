package com.kafka.order.controller;

import com.kafka.order.producer.MessageKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProducerController {

	private final MessageKafkaProducer messageKafkaProducer;

	@PostMapping("/message")
	public void sendStringMessage() throws InterruptedException {
		int i = 0;
		while (i<5) {
			messageKafkaProducer.sendMessage("message" + i++);
			Thread.sleep(1000);
		}
	}
}
