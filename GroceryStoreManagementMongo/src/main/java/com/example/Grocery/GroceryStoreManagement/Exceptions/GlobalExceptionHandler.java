package com.example.Grocery.GroceryStoreManagement.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NonExistingItemIdException.class)
    public ResponseEntity<Object> exception(NonExistingItemIdException exception) {
        return new ResponseEntity<>("Grocery Id not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IdAlreadyExistException.class)
    public ResponseEntity<Object> exception(IdAlreadyExistException exception) {
        return new ResponseEntity<>("Grocery Id already exists.", HttpStatus.NOT_FOUND);
    }
}
