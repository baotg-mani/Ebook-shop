package com.cmcglobal.ebshop.dto.mapper;

import com.cmcglobal.ebshop.dto.OrderDTO;
import com.cmcglobal.ebshop.entity.Order;
import com.cmcglobal.ebshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private CustomerRepository customerRepository;

    @Autowired
    public OrderMapper(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public OrderDTO toDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderDetails(order.getOrderDetails());
        orderDTO.setCreatedDate(order.getCreatedDate());
        orderDTO.setCustomerId(order.getCustomer().getId());
        return orderDTO;
    }

    public Order toOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderDetails(orderDTO.getOrderDetails());
        order.setCreatedDate(orderDTO.getCreatedDate());
        order.setCustomer(customerRepository
                .findById(orderDTO.getCustomerId())
                .get());
        return order;
    }
}
