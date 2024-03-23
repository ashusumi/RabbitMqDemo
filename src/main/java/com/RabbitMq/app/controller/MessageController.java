package com.RabbitMq.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RabbitMq.app.publisher.RabbitMqProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

	@Autowired
	RabbitMqProducer producer;

	@GetMapping("/publish")
	public ResponseEntity<?> getMethodName(@RequestParam("message") String message) {
		producer.sendMessage(message);
		return ResponseEntity.ok("message sent! ");
	}

}
