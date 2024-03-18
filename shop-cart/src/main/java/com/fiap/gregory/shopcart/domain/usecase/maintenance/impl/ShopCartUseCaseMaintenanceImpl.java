package com.fiap.gregory.shopcart.domain.usecase.maintenance.impl;

import com.fiap.gregory.client.infra.db.repository.ClientRepository;
import com.fiap.gregory.client.rest.exceptionhandler.exception.ClientNotFoundException;
import com.fiap.gregory.itemmanager.infra.db.model.Item;
import com.fiap.gregory.itemmanager.infra.db.repository.ItemRepository;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.ItemDataEmptyOrNullException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.ItemNotFoundException;
import com.fiap.gregory.shopcart.domain.mapper.ShopCartMapper;
import com.fiap.gregory.shopcart.domain.usecase.maintenance.ShopCartUseCaseMaintenance;
import com.fiap.gregory.shopcart.infra.db.model.ShopCart;
import com.fiap.gregory.shopcart.infra.db.repository.ShopCartRepository;
import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.fiap.gregory.client.domain.message.ClientMessage.CLIENT_NOT_FOUND;
import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.ITEM_NOT_FOUND;
import static com.fiap.gregory.shopcart.domain.message.ShopCartMessage.SHOP_CART_NOT_FOUND;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShopCartUseCaseMaintenanceImpl implements ShopCartUseCaseMaintenance {

    ShopCartRepository shopCartRepository;
    ClientRepository clientRepository;
    ItemRepository itemRepository;
    ShopCartMapper shopCartMapper;

    @Override
    public void createShopCart(ShopCartRequest request) {
        validateClientAndItem(request);
        request.setIdShopCart(UUID.randomUUID().toString());
        shopCartRepository.save(shopCartMapper.toEntity(request));
    }

    @Override
    public ShopCartResponse increaseProduct(Long id, ShopCartRequest request) {
        validateShopCart(id);
        validateClientAndItem(request);

        var shopCart = shopCartRepository.findByIdShopCart(request.getIdShopCart());
        var updateShopCart = shopCartMapper.toUpdateEntity(request, shopCart);
        shopCartRepository.save(updateShopCart);

        var client = clientRepository.findById(updateShopCart.getClientId()).get();

        var shopCartList = shopCartRepository.findAllByIdShopCart(updateShopCart.getIdShopCart());
        var items = getItemList(shopCartList);

        var clientDto = shopCartMapper.toClientDTO(client);
        var itemsDto = shopCartMapper.toItemDTO(items);

        return shopCartMapper.toResponse(updateShopCart, clientDto, itemsDto);
    }

    @Override
    public void deleteProduct(Long id, String idShopCart, Long itemId) {
        validateShopCart(id);
        var shopcart = shopCartRepository.findByIdShopCartAndItemId(idShopCart, itemId);

        if (Objects.nonNull(shopcart)) {
            shopCartRepository.deleteByItemId(itemId);
        } else {
            throw new ItemDataEmptyOrNullException(ITEM_NOT_FOUND);
        }
    }

    private void validateClientAndItem(ShopCartRequest request) {
        if (!clientExists(request.getClientId())) {
            throw new ClientNotFoundException(CLIENT_NOT_FOUND);
        }

        if (!itemExists(request.getItemId())) {
            throw new ItemNotFoundException(ITEM_NOT_FOUND);
        }
    }

    private void validateShopCart(Long id) {
        if (shopCartExists(id)) {
            throw new ShopCartNotFoundException(SHOP_CART_NOT_FOUND);
        }
    }

    private boolean clientExists(Long idClient) {
        return clientRepository.existsById(idClient);
    }

    private boolean itemExists(Long itemId) {
        return itemRepository.existsById(itemId);
    }

    private boolean shopCartExists(Long id) {
        return !shopCartRepository.existsById(id);
    }

    private List<Item> getItemList(List<ShopCart> shopCarts) {
        List<Item> items = new ArrayList<>();

        for (ShopCart shopCart : shopCarts) {
            var item = itemRepository.findById(shopCart.getItemId()).get();
            items.add(item);
        }
        return items;
    }
}
