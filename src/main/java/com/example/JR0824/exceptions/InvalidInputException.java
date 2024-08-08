package com.example.JR0824.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Invalid parameters for checkout.")
public class InvalidInputException extends RuntimeException{
     public InvalidInputException(String message){
         super(message);
     }

}
