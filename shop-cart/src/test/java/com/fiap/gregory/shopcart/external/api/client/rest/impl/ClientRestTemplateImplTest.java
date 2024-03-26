package com.fiap.gregory.shopcart.external.api.client.rest.impl;

import com.fiap.gregory.shopcart.external.api.client.response.ClientResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ClientRestTemplateImplTest {

    @Mock
    ClientRestTemplateImpl clientRestTemplate;

    final String PATH_API_CLIENT = "http://localhost:8081/v1/client";
    final String PATH_API_CLIENT_ID = PATH_API_CLIENT + "/1";

    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
    }


    @Test
    void getClientById() {
        var clientResponse = Mockito.mock(ClientResponse.class);
        when(clientRestTemplate.getClientById("1")).thenReturn(clientResponse);

        ClientResponse response = restTemplate.getForObject(PATH_API_CLIENT_ID, ClientResponse.class);
        assertNotNull(response);
    }
}