package com.fiap.gregory.shopcart.domain.mapper;

import com.fiap.gregory.client.infra.db.model.Client;
import com.fiap.gregory.itemmanager.infra.db.model.Item;
import com.fiap.gregory.shopcart.domain.dto.ClientDTO;
import com.fiap.gregory.shopcart.domain.dto.ItemDTO;
import com.fiap.gregory.shopcart.infra.db.model.ShopCart;
import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShopCartMapper {

    ShopCart toEntity(ShopCartRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idShopCart", ignore = true)
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "total", target = "total")
    @Mapping(target = "clientId", ignore = true)
    @Mapping(source = "itemId", target = "itemId")
    ShopCart toUpdateEntity(ShopCartRequest request, @MappingTarget ShopCart shopCart);

    @Mapping(source = "shopCart.id", target = "id")
    @Mapping(source = "shopCart.idShopCart", target = "idShopCart")
    @Mapping(source = "shopCart.amount", target = "amount")
    @Mapping(source = "shopCart.total", target = "total")
    @Mapping(source = "clientDTO", target = "client")
    @Mapping(source = "itemsDTO", target = "items")
    ShopCartResponse toResponse(ShopCart shopCart, ClientDTO clientDTO, List<ItemDTO> itemsDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    ClientDTO toClientDTO(Client client);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "price", target = "price")
    List<ItemDTO> toItemDTO(List<Item> item);
}
