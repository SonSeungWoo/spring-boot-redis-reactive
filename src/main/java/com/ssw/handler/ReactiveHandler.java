package com.ssw.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.core.ReactiveListOperations;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ReactiveHandler {

    private final ReactiveStringRedisTemplate redisTemplate;

    private ReactiveListOperations reactiveListOperations;

    private ReactiveListOperations<String, String> listOps;


    public Mono<ServerResponse> getReactive(ServerRequest request) {
        //reactiveListOperations = redisTemplate.opsForList();
        //Mono<String> val = redisTemplate.opsForValue().get("s222");
        //redisTemplate.opsForValue().set("ssw001","seungwoo");
        Flux flux = redisTemplate.scan();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux, new ParameterizedTypeReference<Flux>() {});
    }

    public Mono<ServerResponse> testFlux(ServerRequest request) {
        Flux flux = reactiveListOperations.range("ssw",0,-1);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux, new ParameterizedTypeReference<Flux>() {});
    }
}
