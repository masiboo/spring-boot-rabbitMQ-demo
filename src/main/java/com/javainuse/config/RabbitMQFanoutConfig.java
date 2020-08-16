package com.javainuse.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

    @Bean
    Queue marketingFanoutQueue() {
        return new Queue("marketingFanoutQueue", false);
    }

    @Bean
    Queue financeFanoutQueue() {
        return new Queue("financeFanoutQueue", false);
    }

    @Bean
    Queue adminFanoutQueue() {
        return new Queue("adminFanoutQueue", false);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange");
    }

    @Bean
    Binding fanoutMarketingBinding(Queue marketingQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(marketingQueue).to(exchange);
    }

    @Bean
    Binding fanoutFinanceBinding(Queue financeQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(financeQueue).to(exchange);
    }

    @Bean
    Binding fanoutAdminBinding(Queue adminQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(adminQueue).to(exchange);
    }

    @Bean
    public MessageConverter fanoutJsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    MessageListenerContainer fanoutMessageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        return simpleMessageListenerContainer;
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(fanoutJsonMessageConverter());
        return rabbitTemplate;
    }
}
