package com.fiap.gregory.client.rest.maintenance.impl;

import com.fiap.gregory.client.rest.dto.request.ClientRequest;
import com.fiap.gregory.client.service.maintenance.ClientService;
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

import static com.fiap.gregory.client.domain.message.ClientMessage.PATH_CLIENT;
import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientControllerImplTest {

    @LocalServerPort
    int port;

    @MockBean
    ClientService clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        RestAssured.port = port;
    }

    @Test
    @DisplayName("Should be return a http status 201 - Created")
    void should_ReturnsHttpStatusCreated_when_CreateClientWithSuccess() {
        var request = Mockito.mock(ClientRequest.class);
        doNothing().when(clientService).createClient(any(ClientRequest.class));

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when().post(PATH_CLIENT)
                .then().statusCode(HttpStatus.CREATED.value());

        verify(clientService).createClient(any(ClientRequest.class));
    }
}