package com.prototype.greetings.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class HelloWorldApplication {
	public static  final Logger log = LoggerFactory.getLogger(HelloWorldApplication.class);

	public static void main(String[] args) {

		SpringApplication app= new SpringApplication(HelloWorldApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		System.out.println("WebApp type "+ app.getWebApplicationType().toString());
		ApplicationContext ctx = app.run(args);

		//get Profiles
		System.out.println("======Default profile(s)=====");
		Arrays.stream(ctx.getEnvironment().getDefaultProfiles()).forEach(System.out::println);
		System.out.println("======Active profile(s)=====");
		Arrays.stream(ctx.getEnvironment().getActiveProfiles()).forEach(System.out::println);

		//application related data
		System.out.println("App Name ::"+ ctx.getId());
		System.out.println(ctx.getEnvironment().getProperty("spring.application.name")); // everything in appl properties is a property in Environment instance

		//Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

	}

	@GetMapping("/hello")
	public Greeting getGreetings(@RequestParam(value = "name1", required=true)  String userName){
		return new Greeting(1,"Hello "+userName);
	}

	@Bean
	public RestTemplate getRestTemolate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate){
		return args -> {
			ResponseEntity<Quote> resQuote = restTemplate.getForEntity("https://quoters.apps.pcfone.io/api/random", Quote.class);
			System.out.println(resQuote.getBody().toString());
		};
	}

}
