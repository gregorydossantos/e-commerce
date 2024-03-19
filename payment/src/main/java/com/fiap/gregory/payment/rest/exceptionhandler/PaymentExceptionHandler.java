package com.fiap.gregory.payment.rest.exceptionhandler;

import com.fiap.gregory.payment.rest.exceptionhandler.exception.PaymentBadRequestException;
import com.fiap.gregory.payment.rest.exceptionhandler.exception.PaymentDataEmptyOrNullException;
import com.fiap.gregory.payment.rest.exceptionhandler.exception.PaymentDataIntegrityException;
import com.fiap.gregory.payment.rest.exceptionhandler.exception.PaymentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PaymentExceptionHandler {

    @ExceptionHandler(PaymentBadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestException(final PaymentBadRequestException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaymentDataEmptyOrNullException.class)
    public ResponseEntity<ErrorResponse> dataEmptyOrNullException(final PaymentDataEmptyOrNullException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentDataIntegrityException.class)
    public ResponseEntity<ErrorResponse> dataIntegrityException(final PaymentDataIntegrityException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(final PaymentNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
