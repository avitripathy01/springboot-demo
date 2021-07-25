package com.prototype.greetings.helloworld.hiworld;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy(value = true)
public class HiWorld {
    @GetMapping("/hi")
    public String getGreetings(@RequestParam(value = "name", defaultValue ="springboot !!",
            required=true)  String userName){
        return "Hi "+userName;
    }
}
