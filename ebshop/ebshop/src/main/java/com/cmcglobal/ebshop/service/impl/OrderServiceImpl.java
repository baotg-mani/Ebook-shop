package com.cmcglobal.ebshop.service.impl;

import com.cmcglobal.ebshop.dto.OrderDTO;
import com.cmcglobal.ebshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public List<OrderDTO> getAllOrders() {
        return null;
    }

    @Override
    public OrderDTO getOrderById(long id) {
        return null;
    }

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO updateOrderById(OrderDTO orderDTO, long id) {
        return null;
    }

    @Override
    public void deleteOrderById(long id) {

    }
}
