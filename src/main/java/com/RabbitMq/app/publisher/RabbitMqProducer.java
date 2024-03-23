package com.RabbitMq.app.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMqProducer {

	@Value("${app_exchange}")
	private String exchange;

	@Value("${app_routing_key}")
	private String key;

	private RabbitTemplate rabbitTemplate;

	public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(String message) {
		log.info(String.format("Message sent -> %s", message));
		rabbitTemplate.convertAndSend(exchange, key, message);

	}

}
