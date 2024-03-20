package com.fiap.gregory.payment.service.maintenance;

import com.fiap.gregory.payment.rest.dto.request.PaymentRequest;

public interface PaymentServiceMaintenance {
    void payment(PaymentRequest request);
}
