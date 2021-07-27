package com.prototype.greetings.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyCommandRunner implements CommandLineRunner {

    @Autowired
    RestTemplateBuilder builder;
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Override
    public void run(String ...args) throws  Exception{

            ResponseEntity<Quote> resQuote = getRestTemplate(builder).getForEntity("https://quoters.apps.pcfone.io/api/random", Quote.class);
            System.out.println(resQuote.getBody().toString());

    }

}
