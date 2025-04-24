package org.mysimplelibrary.controller;

import jakarta.validation.ConstraintViolationException;
import org.mysimplelibrary.service.exception.AlreadyExistException;
import org.mysimplelibrary.service.exception.NotFoundException;
import org.mysimplelibrary.service.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<String> handleAlreadyExistException(AlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNullPointerException(NullPointerException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handlerConstraintViolationException(ConstraintViolationException e) {

        StringBuilder responseMessage = new StringBuilder();

        e.getConstraintViolations().forEach(
                constraintViolation -> {
                    String currentErrorMessage = constraintViolation.getMessage();
                    responseMessage.append(currentErrorMessage);
                    responseMessage.append("\n");
                }
        );

        return new ResponseEntity<>(responseMessage.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        StringBuilder responseMessage = new StringBuilder();

        e.getBindingResult().getAllErrors().forEach(
                objectError -> {
                    String fieldName = ((FieldError) objectError).getField();
                    String currentErrorMessage = objectError.getDefaultMessage();
                    responseMessage.append(fieldName + " : " + currentErrorMessage);
                    responseMessage.append("\n");
                }
        );

        return new ResponseEntity<>(responseMessage.toString(), HttpStatus.BAD_REQUEST);
    }

}
