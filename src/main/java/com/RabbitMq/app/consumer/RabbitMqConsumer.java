package com.RabbitMq.app.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMqConsumer {

	@RabbitListener(queues = "${app_queue}")
	public void consume(String message) {
		log.info(String.format("Message recieved -> %s", message));

	}

}
