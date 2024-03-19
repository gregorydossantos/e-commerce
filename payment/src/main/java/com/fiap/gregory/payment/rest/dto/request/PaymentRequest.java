package com.fiap.gregory.payment.rest.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import static com.fiap.gregory.payment.domain.message.PaymentMessage.FIELD_MANDATORY;

@Data
@Builder
@NotNull(message = FIELD_MANDATORY)
@NotEmpty(message = FIELD_MANDATORY)
public class PaymentRequest {

    private Long idShopCart;
}
