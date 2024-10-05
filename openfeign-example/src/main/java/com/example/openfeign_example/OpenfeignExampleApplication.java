package com.example.openfeign_example;

import com.example.openfeign_example.client.IbgeClient;
import com.example.openfeign_example.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class OpenfeignExampleApplication implements CommandLineRunner {

	@Autowired
	IbgeClient ibgeClient;

	public static void main(String[] args) {
		SpringApplication.run(OpenfeignExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Estado> estados = ibgeClient.obterEstados();

		for (Estado estado : estados) {
			System.out.println(estado.getNome());
		}
	}
}
