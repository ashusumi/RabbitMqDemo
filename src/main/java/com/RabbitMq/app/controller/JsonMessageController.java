package com.RabbitMq.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RabbitMq.app.dto.User;
import com.RabbitMq.app.publisher.RabbitMqJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class JsonMessageController {

	@Autowired
	private RabbitMqJsonProducer producer;

	@PostMapping("/publish")
	public ResponseEntity<?> getMethodName(@RequestBody User user) {
		producer.sendJsonMessage(user);
		return ResponseEntity.ok("Json Message Sent!");
	}

}
