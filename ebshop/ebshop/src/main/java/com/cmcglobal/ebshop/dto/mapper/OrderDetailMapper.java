package com.cmcglobal.ebshop.dto.mapper;

import com.cmcglobal.ebshop.dto.OrderDetailDTO;
import com.cmcglobal.ebshop.entity.OrderDetail;
import com.cmcglobal.ebshop.repository.EbookRepository;
import com.cmcglobal.ebshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EbookRepository ebookRepository;

    public OrderDetailDTO toDto(OrderDetail orderDetail) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setOrderId(orderDetail.getOrder().getId());
        orderDetailDTO.setEbookId(orderDetail.getEbook().getId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        return orderDetailDTO;
    }

    public OrderDetail toOrderDetail(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(orderRepository
                .findById(orderDetailDTO.getOrderId())
                .get());
        orderDetail.setEbook(ebookRepository
                .findById(orderDetailDTO.getEbookId())
                .get());
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        return orderDetail;
    }
}
