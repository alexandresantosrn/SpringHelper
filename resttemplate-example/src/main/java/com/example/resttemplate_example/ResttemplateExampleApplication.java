package com.example.resttemplate_example;

import model.Estado;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ResttemplateExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ResttemplateExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-- Rest Template --");
		System.out.println("\n");

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://servicodados.ibge.gov.br/api/v1/localidades/estados";

		Estado[] estadoArray = restTemplate.getForObject(url, Estado[].class);

        List<Estado> estados = null;
        if (estadoArray != null) {
            estados = Arrays.asList(estadoArray);
        }

        System.out.println(" Json formatado:");
        if (estados != null) {
            estados.forEach(System.out::println);
        }

        System.out.println("\n");
		System.out.println(" Dados organizados:");
        if (estados != null) {
            for (Estado estado : estados) {
                System.out.print(estado.getId());
                System.out.print(" - ");
                System.out.println(estado.getNome());
            }
        }

    }
}
