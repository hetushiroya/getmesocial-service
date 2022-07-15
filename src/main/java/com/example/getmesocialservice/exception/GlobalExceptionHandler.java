package com.example.getmesocialservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElement(){
        return new ResponseEntity<>( "No such element found", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RestrictedInfo.class)
    public ResponseEntity<String> restrictedInfoError(RestrictedInfo restrictedInfo){
        return new ResponseEntity<>(restrictedInfo.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
