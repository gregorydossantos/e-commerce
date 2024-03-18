package com.fiap.gregory.shopcart.rest.exceptionhandler;

import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartBadRequestException;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartDataEmptyOrNullException;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartDataIntegrityException;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopCartExceptionHandler {

    @ExceptionHandler(ShopCartBadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestException(final ShopCartBadRequestException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ShopCartDataEmptyOrNullException.class)
    public ResponseEntity<ErrorResponse> dataEmptyOrNullException(final ShopCartDataEmptyOrNullException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ShopCartDataIntegrityException.class)
    public ResponseEntity<ErrorResponse> dataIntegrityException(final ShopCartDataIntegrityException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ShopCartNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(final ShopCartNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
