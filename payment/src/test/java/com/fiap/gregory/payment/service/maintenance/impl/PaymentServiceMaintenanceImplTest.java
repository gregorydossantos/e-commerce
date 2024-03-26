package com.fiap.gregory.payment.service.maintenance.impl;

import com.fiap.gregory.payment.domain.usecase.maintenance.PaymentUseCaseMaintenance;
import com.fiap.gregory.payment.rest.dto.request.PaymentRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class PaymentServiceMaintenanceImplTest {

    @Mock
    PaymentUseCaseMaintenance useCaseMaintenance;

    @InjectMocks
    PaymentServiceMaintenanceImpl serviceMaintenance;

    @Test
    @DisplayName("SERVICE LAYER ::: Make a payment")
    void payment() {
        var request = Mockito.mock(PaymentRequest.class);
        doNothing().when(useCaseMaintenance).payment(request);

        serviceMaintenance.payment(request);
        verify(useCaseMaintenance).payment(request);
    }
}