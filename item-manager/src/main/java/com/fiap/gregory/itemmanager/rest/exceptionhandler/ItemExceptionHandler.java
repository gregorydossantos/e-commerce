package com.fiap.gregory.itemmanager.rest.exceptionhandler;

import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.ItemBadRequestException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.ItemDataEmptyOrNullException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.ItemDataIntegrityException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemExceptionHandler {

    @ExceptionHandler(ItemBadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestException(final ItemBadRequestException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemDataEmptyOrNullException.class)
    public ResponseEntity<ErrorResponse> dataEmptyOrNullException(final ItemDataEmptyOrNullException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemDataIntegrityException.class)
    public ResponseEntity<ErrorResponse> dataIntegrityException(final ItemDataIntegrityException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(final ItemNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
