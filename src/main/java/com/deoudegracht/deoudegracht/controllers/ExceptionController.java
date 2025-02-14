package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.exceptions.ExistingUsernameException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<String> exception(IndexOutOfBoundsException exception)
    {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ExistingUsernameException.class)
    public ResponseEntity<String> exception(ExistingUsernameException exception)
    {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler( value = DataIntegrityViolationException.class)
    public ResponseEntity<String> exception(DataIntegrityViolationException exception)
    {
        return new ResponseEntity<>("null value in column hdr", HttpStatus.BAD_REQUEST);
    }

}
