package com.prototype.greetings.helloworld;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class MyCl1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Response from cl1");
    }
}
