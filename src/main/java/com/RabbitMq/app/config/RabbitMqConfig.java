package com.RabbitMq.app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	// Define a bean for your queue
	@Bean
	public Queue queue() {
		return new Queue("niampinfotech");
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("nm_exchange");
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with("nimap_infotech_routing_key");
	}
}
