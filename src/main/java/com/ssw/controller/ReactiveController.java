package com.ssw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveController {

    @GetMapping("/helloword")
    public Mono<String> hello() {
        throw new NumberFormatException();
        //return Mono.just("hello word!");
    }

}
