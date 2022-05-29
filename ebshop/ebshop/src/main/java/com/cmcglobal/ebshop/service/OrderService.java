package com.cmcglobal.ebshop.service;

import com.cmcglobal.ebshop.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(long id);

    OrderDTO addOrder(OrderDTO orderDTO);

    OrderDTO updateOrderById(OrderDTO orderDTO, long id);

    void deleteOrderById(long id);
}
