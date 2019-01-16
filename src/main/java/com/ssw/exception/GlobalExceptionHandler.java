package com.ssw.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Mono;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.info("===============handleException============");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleConflict(IllegalArgumentException e) {
        logger.info("==============handleConflict=============");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NumberFormatException.class)
    public Mono<String> handleNumberFormatlict(IllegalArgumentException e) {
        logger.info("==============handleNumberFormatlict=============");
        return Mono.just(e.getMessage());
    }

}
