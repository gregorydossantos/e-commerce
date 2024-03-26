package com.fiap.gregory.payment.domain.usecase.maintenance.impl;

import com.fiap.gregory.payment.domain.mapper.PaymentMapper;
import com.fiap.gregory.payment.external.api.shoppingcart.response.ShopCartResponse;
import com.fiap.gregory.payment.external.api.shoppingcart.rest.ShopCartRestTemplate;
import com.fiap.gregory.payment.infra.db.model.Payment;
import com.fiap.gregory.payment.infra.db.repository.PaymentRepository;
import com.fiap.gregory.payment.rest.dto.request.PaymentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class PaymentUseCaseMaintenanceImplTest {

    @Mock
    PaymentRepository paymentRepository;

    @Mock
    PaymentMapper paymentMapper;

    @Mock
    ShopCartRestTemplate shopCartRestTemplate;

    @InjectMocks
    PaymentUseCaseMaintenanceImpl useCaseMaintenance;

    PaymentRequest request;
    ShopCartResponse shopCartResponse;
    Payment payment;

    @BeforeEach
    void setUp() {
        request = Mockito.mock(PaymentRequest.class);
        shopCartResponse = Mockito.mock(ShopCartResponse.class);
        payment = Mockito.mock(Payment.class);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: Make a Payment")
    void payment() {
        when(shopCartRestTemplate.getShoppingCartById(1L)).thenReturn(shopCartResponse);
        when(paymentMapper.toEntity(request)).thenReturn(payment);

        useCaseMaintenance.payment(request);
        verify(paymentRepository).save(payment);
    }
}