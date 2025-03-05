package com.example.rabbit_producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitProducerApplication {

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) throws Exception {
		startProducer();
		SpringApplication.run(RabbitProducerApplication.class, args);
	}

	private static void startProducer() throws Exception{

		ConnectionFactory factory = new ConnectionFactory();

		factory.setHost("localhost");
		factory.setUsername("admin");
		factory.setPassword("123456");

        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Sent '"  + message + "'");
        }

    }

}
