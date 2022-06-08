package com.cmcglobal.ebshop.dto;

import com.cmcglobal.ebshop.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private List<Order> orders;

}
