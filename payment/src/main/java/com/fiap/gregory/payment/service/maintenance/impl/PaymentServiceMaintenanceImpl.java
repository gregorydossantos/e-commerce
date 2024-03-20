package com.fiap.gregory.payment.service.maintenance.impl;

import com.fiap.gregory.payment.domain.usecase.maintenance.PaymentUseCaseMaintenance;
import com.fiap.gregory.payment.rest.dto.request.PaymentRequest;
import com.fiap.gregory.payment.service.maintenance.PaymentServiceMaintenance;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PaymentServiceMaintenanceImpl implements PaymentServiceMaintenance {

    PaymentUseCaseMaintenance useCaseMaintenance;

    @Override
    public void payment(PaymentRequest request) {
        useCaseMaintenance.payment(request);
    }
}
