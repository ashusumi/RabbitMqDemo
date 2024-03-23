package com.RabbitMq.app.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.RabbitMq.app.dto.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMqJsonConsumer {

	@RabbitListener(queues = "${json_queue}")
	public void consume(User user) {
		log.info(String.format("Message recieved -> %s", user.toString()));

	}

}
