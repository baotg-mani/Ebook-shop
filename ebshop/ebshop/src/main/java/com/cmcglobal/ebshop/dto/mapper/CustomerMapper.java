package com.cmcglobal.ebshop.dto.mapper;

import com.cmcglobal.ebshop.dto.CustomerDTO;
import com.cmcglobal.ebshop.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDTO toDto(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(customer.getFirstname());
        customerDTO.setLastname(customer.getLastname());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setOrders(customer.getOrders());
        customerDTO.setPhone(customer.getPhone());
        return customerDTO;
    }

    public Customer toCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirstname(customerDTO.getFirstname());
        customer.setLastname(customerDTO.getLastname());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setOrders(customerDTO.getOrders());
        customer.setPhone(customerDTO.getPhone());
        return customer;
    }
}
