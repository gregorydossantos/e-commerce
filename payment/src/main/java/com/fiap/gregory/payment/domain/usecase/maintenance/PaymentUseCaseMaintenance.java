package com.fiap.gregory.payment.domain.usecase.maintenance;

import com.fiap.gregory.payment.rest.dto.request.PaymentRequest;

public interface PaymentUseCaseMaintenance {
    void payment(PaymentRequest request);
}
