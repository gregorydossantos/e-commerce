package com.fiap.gregory.shopcart.external.api.client.rest.impl;

import com.fiap.gregory.shopcart.external.api.client.response.ClientResponse;
import com.fiap.gregory.shopcart.external.api.client.rest.ClientRestTemplate;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartDataEmptyOrNullException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static com.fiap.gregory.shopcart.domain.message.ShopCartMessage.CLIENT_NOT_FOUND;

@RestController
public class ClientRestTemplateImpl implements ClientRestTemplate {

    private static final String PATH_API_CLIENT = "http://localhost:8081/v1/client/";

    @Override
    public ClientResponse getClientById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.getForObject(PATH_API_CLIENT + id, ClientResponse.class);

        if (Objects.isNull(response)) {
            throw new ShopCartDataEmptyOrNullException(CLIENT_NOT_FOUND);
        }

        return response;
    }
}
