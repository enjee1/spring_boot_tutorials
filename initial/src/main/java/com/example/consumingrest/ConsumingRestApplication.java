package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ConsumingRestApplication {

	private static final String NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=VD4aSgn9cxh7HPv0NQ0ygecENulZjl182e8mAsNX";

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run (RestTemplate restTemplate) throws Exception {
		return args -> {
			APOD apod = restTemplate.getForObject(NASA_URL, APOD.class);
//			System.out.println(apod.getTitle());
			log.info(apod.getTitle());
		};
	}

	@GetMapping("/api-data")
	public String info (RestTemplate restTemplate) {

		APOD apod = restTemplate.getForObject(NASA_URL, APOD.class);

		return apod.toString();

	}

}
