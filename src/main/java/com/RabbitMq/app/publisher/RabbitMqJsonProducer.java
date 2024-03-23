package com.RabbitMq.app.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.RabbitMq.app.dto.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMqJsonProducer {

	@Value("${app_exchange}")
	private String exchange;

	@Value("${json_routing_key}")
	private String jsonKey;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendJsonMessage(User user) {
		log.info(String.format("Json message sent -> %s", user.toString()));
		rabbitTemplate.convertAndSend(exchange, jsonKey, user);
	}
}
