package com.example.order.service.service;

import com.example.order.service.entity.Order;
import com.example.order.service.entity.OrderOutBox;
import com.example.order.service.model.OrderRequestDTO;
import com.example.order.service.repository.OrderRepository;
import com.example.order.service.repository.OutBoxRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OutBoxRepository outBoxRepository;


    public OrderService(OrderRepository orderRepository, OutBoxRepository outBoxRepository) {
        this.orderRepository = orderRepository;
        this.outBoxRepository = outBoxRepository;
    }

    @Transactional
    public Order createNewOrder(OrderRequestDTO requestDTO){
        Order save = orderRepository.save(mapper(requestDTO));
        OrderOutBox outBox = outBoxRepository.save(mapper(save));
        log.info("order created : {},order outBoxed : {}",save,outBox);
        return save;
    }

    public Order mapper(OrderRequestDTO orderRequestDTO){
        return Order.builder()
                .productName(orderRequestDTO.getProductName())
                .customerId(orderRequestDTO.getCustomerId())
                .productType(orderRequestDTO.getProductType())
                .quantity(orderRequestDTO.getQuantity())
                .price(orderRequestDTO.getPrice())
                .orderDate(new Date())
                .build();
    }

    @SneakyThrows
    public OrderOutBox mapper(Order order){
        return OrderOutBox.builder()
                .aggregateId(String.valueOf(order.getId()))
                .payload(new ObjectMapper().writeValueAsString(order))
                .createdAt(new Date())
                .processed(false)
                .build();
    }


}
