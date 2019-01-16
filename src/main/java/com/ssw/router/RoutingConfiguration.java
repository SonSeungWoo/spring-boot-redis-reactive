package com.ssw.router;

import com.ssw.handler.ReactiveHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RoutingConfiguration {

    private final ReactiveHandler reactiveHandler;

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction() {
        return route(GET("/reactive")
                .and(accept(APPLICATION_JSON)), reactiveHandler::getReactive);
    }

    @Bean
    public RouterFunction<ServerResponse> testFluxFucntion() {
        return route(GET("/reactive/test")
                .and(accept(APPLICATION_JSON)), reactiveHandler::testFlux);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTest() {
        //return route(GET("/hello").and(accept(APPLICATION_JSON)), reactiveHandler::hello);
        return RouterFunctions
                .route(RequestPredicates
                        .GET("/hello")
                        .and(RequestPredicates
                                .accept(APPLICATION_JSON)), reactiveHandler::hello);
    }

    @Bean
    public RouterFunction<ServerResponse> ex1Test(){
        return route(GET("/exception").and(accept(APPLICATION_JSON)), reactiveHandler::exceptionTest);
    }
}
