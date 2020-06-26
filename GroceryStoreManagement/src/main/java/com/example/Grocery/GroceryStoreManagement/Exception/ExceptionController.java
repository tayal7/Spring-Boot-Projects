package com.example.Grocery.GroceryStoreManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = GroceryNotFoundException.class)
    public ResponseEntity<Object> exception(GroceryNotFoundException exception) {
        return new ResponseEntity<>("Grocery not found", HttpStatus.NOT_FOUND);
    }
}
