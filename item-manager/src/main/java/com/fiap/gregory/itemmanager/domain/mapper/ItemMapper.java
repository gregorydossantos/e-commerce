package com.fiap.gregory.itemmanager.domain.mapper;

import com.fiap.gregory.itemmanager.infra.db.model.Item;
import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<ItemResponse> toResponseList(List<Item> itemList);

    ItemResponse toResponse(Item item);

    Item toEntity(ItemRequest request);

    Item toUpdate(Item item, ItemRequest itemRequest);
}
