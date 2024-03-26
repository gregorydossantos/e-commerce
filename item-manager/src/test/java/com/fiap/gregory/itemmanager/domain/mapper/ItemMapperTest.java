package com.fiap.gregory.itemmanager.domain.mapper;

import com.fiap.gregory.itemmanager.infra.db.model.Item;
import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class ItemMapperTest {

    @Autowired
    ItemMapper mapper;

    @Test
    void should_ReturnsResponseList_When_CallToResponseListMethod() {
        var item = Mockito.mock(Item.class);
        var itemList = List.of(item);
        var responseList = mapper.toResponseList(itemList);
        assertNotNull(responseList);
    }

    @Test
    void should_ReturnsResponse_When_CallToResponseMethod() {
        var item = Mockito.mock(Item.class);
        var response = mapper.toResponse(item);
        assertNotNull(response);
    }

    @Test
    void should_ReturnsEntity_When_CallToEntityMethod() {
        var itemRequest = Mockito.mock(ItemRequest.class);
        var entity = mapper.toEntity(itemRequest);
        assertNotNull(entity);
    }

    @Test
    void should_ReturnsUpdateEntity_When_CallToUpdateMethod() {
        var itemRequest = Mockito.mock(ItemRequest.class);
        var item = Mockito.mock(Item.class);
        var entityUpdate = mapper.toUpdate(item, itemRequest);
        assertNotNull(entityUpdate);
    }
}