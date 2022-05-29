package com.cmcglobal.ebshop.controller;

import com.cmcglobal.ebshop.dto.OrderDetailDTO;
import com.cmcglobal.ebshop.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order-detail")
public class OrderDetailController {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @GetMapping
    public ResponseEntity<OrderDetailDTO> getAllOrderDetails() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailDTO> getOrderDetailById(@PathVariable long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<OrderDetailDTO> createOrderDetail(@Valid @RequestBody OrderDetailDTO orderDetail) {
        return null;
    }

    @PutMapping("/id")
    public ResponseEntity<OrderDetailDTO> updateOrderDetail(@Valid @RequestBody OrderDetailDTO orderDetail, @PathVariable long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDetailDTO> deleteOrderDetail(@PathVariable long id) {
        return null;
    }
}
