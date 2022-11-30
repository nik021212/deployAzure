package com.soprasteria.terna.mymicroservice.utenti;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class MyMicroservice implements CommandLineRunner {
	@Value("${sample.property}")
	String myMessage;

	public static void main (String[] args) {
		SpringApplication.run(MyMicroservice.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		log.info(myMessage);
	}
}
