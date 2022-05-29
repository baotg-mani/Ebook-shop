package com.cmcglobal.ebshop.dto;

import com.cmcglobal.ebshop.entity.Customer;
import com.cmcglobal.ebshop.entity.OrderDetail;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private Long customerId;
    private Date createdDate;
    private List<OrderDetail> orderDetails;

}
