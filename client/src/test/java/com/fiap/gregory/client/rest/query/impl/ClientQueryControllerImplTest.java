package com.fiap.gregory.client.rest.query.impl;

import com.fiap.gregory.client.rest.dto.response.ClientResponse;
import com.fiap.gregory.client.service.query.ClientQueryService;
import com.fiap.gregory.client.service.query.impl.ClientQueryServiceImpl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.persistence.Id;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientQueryControllerImplTest {

    @LocalServerPort
    int port;

    @MockBean
    ClientQueryService clientQueryService;

    ClientResponse clientResponse;

    private static final String PATH_CLIENT_ID = "/v1/client/1";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientResponse = Mockito.mock(ClientResponse.class);
        RestAssured.port = port;
    }

    @Test
    @DisplayName("Should be return a http status 200 - SUCCESS")
    void should_ReturnsHttpStatusSuccess_when_GetAClientWithSuccess() {
        when(clientQueryService.getClientById(1L)).thenReturn(clientResponse);

        given()
                .contentType(ContentType.JSON)
                .when().get(PATH_CLIENT_ID)
                .then().statusCode(HttpStatus.OK.value());

    }
}