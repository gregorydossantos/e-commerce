package com.fiap.gregory.payment.domain.usecase.maintenance.impl;

import com.fiap.gregory.payment.domain.mapper.PaymentMapper;
import com.fiap.gregory.payment.domain.usecase.maintenance.PaymentUseCaseMaintenance;
import com.fiap.gregory.payment.infra.db.repository.PaymentRepository;
import com.fiap.gregory.payment.rest.dto.request.PaymentRequest;
import com.fiap.gregory.payment.rest.exceptionhandler.exception.PaymentNotFoundException;
import com.fiap.gregory.shopcart.infra.db.repository.ShopCartRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.fiap.gregory.payment.domain.message.PaymentMessage.SHOP_CART_DATA_NOT_FOUND;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PaymentUseCaseMaintenanceImpl implements PaymentUseCaseMaintenance {

    PaymentRepository paymentRepository;
    PaymentMapper paymentMapper;
    ShopCartRepository shopCartRepository;

    @Override
    public void payment(PaymentRequest request) {
        if (!shopCartExists(request)) {
            throw new PaymentNotFoundException(SHOP_CART_DATA_NOT_FOUND);
        }

        paymentRepository.save(paymentMapper.toEntity(request));
    }

    private boolean shopCartExists(PaymentRequest request) {
        return shopCartRepository.existsById(request.getIdShopCart());
    }
}
