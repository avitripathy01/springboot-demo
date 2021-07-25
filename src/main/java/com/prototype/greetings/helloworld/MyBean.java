package com.prototype.greetings.helloworld;

import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBean {

    public MyBean(ApplicationArguments args){

        Arrays.stream(args.getSourceArgs()).forEach(arg -> {
            System.out.println(args.getOptionValues(arg));
        });
    }
}
