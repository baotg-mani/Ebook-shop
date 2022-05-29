package com.cmcglobal.ebshop.controller;

import com.cmcglobal.ebshop.dto.OrderDTO;
import com.cmcglobal.ebshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> ordersRes = orderService.getAllOrders();
        return ResponseEntity.ok(ordersRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable long id) {
        OrderDTO orderRes = orderService.getOrderById(id);
        return ResponseEntity.ok(orderRes);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO orderRes = orderService.addOrder(orderDTO);
        return ResponseEntity.ok(orderRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrderById(@Valid @RequestBody OrderDTO orderDTO
            , @PathVariable long id) {
        OrderDTO orderRes = orderService.updateOrderById(orderDTO, id);
        return ResponseEntity.ok(orderRes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok("Delete success!");
    }
}
