package com.fiap.gregory.payment.rest.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import static com.fiap.gregory.payment.domain.message.PaymentMessage.FIELD_MANDATORY;
import static com.fiap.gregory.payment.domain.message.PaymentMessage.INVALID_VALUE_FIELD_OPERATION;

@Data
@Builder
@NotNull(message = FIELD_MANDATORY)
@NotEmpty(message = FIELD_MANDATORY)
public class PaymentRequest {

    @Pattern(regexp = "^[c-dC-D]", message = INVALID_VALUE_FIELD_OPERATION)
    private String operation;
    private Boolean paid;
    private Long idShopCart;
}
