package com.fiap.gregory.payment.rest.maintenance;

import com.fiap.gregory.payment.rest.dto.request.PaymentRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface PaymentMaintenanceController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<String> payment(@RequestBody @Valid PaymentRequest request);
}
