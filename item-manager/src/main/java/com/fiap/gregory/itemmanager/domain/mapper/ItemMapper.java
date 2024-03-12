package com.fiap.gregory.itemmanager.domain.mapper;

import com.fiap.gregory.itemmanager.infra.db.model.Item;
import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<ItemResponse> toResponseList(List<Item> itemList);

    ItemResponse toResponse(Item item);

    Item toEntity(ItemRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "product", target = "product")
    @Mapping(source = "price", target = "price")
    Item toUpdate(@MappingTarget Item item, ItemRequest itemRequest);
}
