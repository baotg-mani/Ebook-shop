package com.cmcglobal.ebshop.service;

import com.cmcglobal.ebshop.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(long id);

    CustomerDTO addCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomerById(CustomerDTO customerDTO, long id);

    void deleteCustomerById(long id);
}
