package com.fiap.gregory.shopcart.domain.usecase.maintenance.impl;

import com.fiap.gregory.shopcart.domain.mapper.ShopCartMapper;
import com.fiap.gregory.shopcart.domain.usecase.maintenance.ShopCartUseCaseMaintenance;
import com.fiap.gregory.shopcart.external.api.client.rest.ClientRestTemplate;
import com.fiap.gregory.shopcart.external.api.item.rest.ItemRestTemplate;
import com.fiap.gregory.shopcart.infra.db.repository.ShopCartRepository;
import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.fiap.gregory.shopcart.domain.message.ShopCartMessage.SHOP_CART_NOT_FOUND;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShopCartUseCaseMaintenanceImpl implements ShopCartUseCaseMaintenance {

    ShopCartRepository shopCartRepository;
    ShopCartMapper shopCartMapper;
    ClientRestTemplate clientRestTemplate;
    ItemRestTemplate itemRestTemplate;

    @Override
    public void createShopCart(ShopCartRequest request) {
        validateClient(request.getClientId());
        validateItem(request.getItemId());

        shopCartRepository.save(shopCartMapper.toEntity(request));
    }

    @Override
    public ShopCartResponse increaseProduct(Long id, ShopCartRequest request) {
        validateShopCart(id);
        validateClient(request.getClientId());
        validateItem(request.getItemId());

        var shopCart = shopCartRepository.findById(id).get();
        var updateShopCart = shopCartMapper.toUpdateEntity(request, shopCart);
        shopCartRepository.save(updateShopCart);

        return shopCartMapper.toResponse(updateShopCart);
    }

    @Override
    public void deleteProduct(Long id) {
        validateShopCart(id);

        shopCartRepository.deleteById(id);
    }

    private void validateShopCart(Long id) {
        if (!shopCartExists(id)) {
            throw new ShopCartNotFoundException(SHOP_CART_NOT_FOUND);
        }
    }

    private boolean shopCartExists(Long id) {
        return shopCartRepository.existsById(id);
    }

    private void validateClient(Long clientId) {
        clientRestTemplate.getClientById(clientId);
    }

    private void validateItem(Long itemId) {
        itemRestTemplate.getItemById(itemId);
    }
}
