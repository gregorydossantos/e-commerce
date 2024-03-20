package com.fiap.gregory.payment.domain.mapper;

import com.fiap.gregory.payment.infra.db.model.Payment;
import com.fiap.gregory.payment.rest.dto.request.PaymentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toEntity(PaymentRequest request);
}
