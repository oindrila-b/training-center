package com.example.Liv2Train.exceptionhandlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({UnexpectedTypeException.class})
    public ResponseEntity<String> handleUnexpectedTypeException(final UnexpectedTypeException e) {
        log.error("Empty Fields Received : ", e);
        return ResponseEntity.internalServerError().build();
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<String> handleConstraintViolationExceptions(final ConstraintViolationException e) {
        log.error("Handling Constraint Violation Exception : \n", e);
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleError(final Exception e) {
        log.error("Handling Error: ", e);
        return ResponseEntity.badRequest().body("Empty fields or Invalid Value :  \n" +  e);
    }

}
