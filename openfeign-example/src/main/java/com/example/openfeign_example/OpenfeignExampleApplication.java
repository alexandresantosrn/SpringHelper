package com.example.openfeign_example;

import com.example.openfeign_example.client.IbgeClient;
import com.example.openfeign_example.model.Estado;
import com.example.openfeign_example.model.Municipio;
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
		System.out.println("-- Feign --");
		System.out.println("\n");
		System.out.println(" Mostrando Json com ToString:");
		System.out.println(ibgeClient.obterEstados());

		List<Estado> estados = ibgeClient.obterEstados();
		List<Municipio> municipiosRN = ibgeClient.obterMunicipiosRN();

		System.out.println("\n");
		System.out.println(" Json formatado:");
		estados.forEach(System.out::println);

		System.out.println("\n");
		System.out.println(" Dados organizados:");
		for (Estado estado : estados) {
			System.out.print(estado.getId());
			System.out.print(" - ");
			System.out.println(estado.getNome());
		}

		System.out.println("\n");

		for (Municipio municipio : municipiosRN) {
			System.out.print(municipio.getId());
			System.out.print(" - ");
			System.out.println(municipio.getNome());
		}
	}
}
