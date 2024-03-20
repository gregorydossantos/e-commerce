package com.fiap.gregory.payment.rest.maintenance.impl;

import com.fiap.gregory.payment.rest.dto.request.PaymentRequest;
import com.fiap.gregory.payment.rest.maintenance.PaymentMaintenanceController;
import com.fiap.gregory.payment.service.maintenance.PaymentServiceMaintenance;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fiap.gregory.payment.domain.message.PaymentMessage.PATH_PAYMENT;
import static com.fiap.gregory.payment.domain.message.PaymentMessage.SUCCESS_PAYMENT;

@RestController
@AllArgsConstructor
@Tag(name = "Payment Controller")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = PATH_PAYMENT, produces = {"application/json"})
public class PaymentMaintenanceControllerImpl implements PaymentMaintenanceController {

    PaymentServiceMaintenance serviceMaintenance;

    @Operation(summary = "Payment a shopping cart", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully payment shopping cart"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<String> payment(PaymentRequest request) {
        serviceMaintenance.payment(request);
        return ResponseEntity.ok().body(SUCCESS_PAYMENT);
    }
}
