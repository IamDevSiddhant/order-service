package com.example.order.service.controller;

import com.example.order.service.model.OrderRequestDTO;
import com.example.order.service.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/orders/v1")
public class OrdersController {

    private final OrderService service;

    public OrdersController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        log.info("order received payload : {}",orderRequestDTO);
        return new ResponseEntity<>(service.createNewOrder(orderRequestDTO), HttpStatus.CREATED);
    }

}
