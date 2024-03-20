package com.fiap.gregory.shopcart.domain.mapper;

import com.fiap.gregory.shopcart.infra.db.model.ShopCart;
import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ShopCartMapper {

    ShopCart toEntity(ShopCartRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "total", target = "total")
    @Mapping(target = "clientId", ignore = true)
    @Mapping(source = "itemId", target = "itemId")
    ShopCart toUpdateEntity(ShopCartRequest request, @MappingTarget ShopCart shopCart);

    ShopCartResponse toResponse(ShopCart shopCart);
}
