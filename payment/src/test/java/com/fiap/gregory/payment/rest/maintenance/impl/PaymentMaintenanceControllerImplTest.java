package com.fiap.gregory.payment.rest.maintenance.impl;

import com.fiap.gregory.payment.rest.dto.request.PaymentRequest;
import com.fiap.gregory.payment.service.maintenance.PaymentServiceMaintenance;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static com.fiap.gregory.payment.domain.message.PaymentMessage.PATH_PAYMENT;
import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentMaintenanceControllerImplTest {

    @LocalServerPort
    int port;

    @MockBean
    PaymentServiceMaintenance serviceMaintenance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        RestAssured.port = port;
    }

    @Test
    @DisplayName("REST LAYER - Make a payment ::: Should be return a http status 200 - OK")
    void payment() {
        var request = Mockito.mock(PaymentRequest.class);
        doNothing().when(serviceMaintenance).payment(request);

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when().post(PATH_PAYMENT)
                .then().statusCode(HttpStatus.OK.value());

        verify(serviceMaintenance).payment(any(PaymentRequest.class));
    }
}