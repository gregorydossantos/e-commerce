package com.fiap.gregory.payment.domain.mapper;

import com.fiap.gregory.payment.rest.dto.request.PaymentRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class PaymentMapperTest {

    @Autowired
    PaymentMapper mapper;

    @Test
    void should_ReturnsEntity_When_CallToEntityMethod() {
        var resquest = Mockito.mock(PaymentRequest.class);
        var entity = mapper.toEntity(resquest);
        assertNotNull(entity);
    }
}