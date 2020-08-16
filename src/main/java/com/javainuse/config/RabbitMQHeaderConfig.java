/*
package com.javainuse.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeaderConfig {

	@Bean
	Queue headerMarketingQueue() {
		return new Queue("header-marketingQueue", false);
	}

	@Bean
	Queue headerFinanceQueue() {
		return new Queue("header-financeQueue", false);
	}

	@Bean
	Queue headerAdminQueue() {
		return new Queue("header-adminQueue", false);
	}

	@Bean
	HeadersExchange headerExchange() {
		return new HeadersExchange("header-exchange");
	}

	@Bean
	Binding headerMarketingBinding(Queue marketingQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(marketingQueue).to(headerExchange).where("department").matches("marketing");
	}

	@Bean
	Binding headerFinanceBinding(Queue financeQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(financeQueue).to(headerExchange).where("department").matches("finance");
	}

	@Bean
	Binding headerAdminBinding(Queue adminQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(adminQueue).to(headerExchange).where("department").matches("admin");
	}

	@Bean
	public MessageConverter headerJsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	MessageListenerContainer headerMessageListenerContainer(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
		return simpleMessageListenerContainer;
	}

	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(headerJsonMessageConverter());
		return rabbitTemplate;
	}
}
*/