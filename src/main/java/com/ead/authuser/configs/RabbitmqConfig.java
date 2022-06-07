package com.ead.authuser.configs;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class RabbitmqConfig {
	
	//leva em consideração o endereço da instância do clouamqp que definimos no application.yml
	@Autowired
	CachingConnectionFactory cachingConnectionFactory;
	
	//Precisaremos de uma instância de RabbitTemplate em nosso publisher
	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(cachingConnectionFactory);
		template.setMessageConverter(messageConverter());
		return template;
	}
	
	//Sempre precisaremos desta conversão para enviar e receber mensagens, especialmente quando vamos lidar com datas
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		return new Jackson2JsonMessageConverter(objectMapper);
	}

}
