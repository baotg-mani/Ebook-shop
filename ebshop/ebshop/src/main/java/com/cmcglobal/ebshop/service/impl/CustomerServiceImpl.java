package com.cmcglobal.ebshop.service.impl;

import com.cmcglobal.ebshop.dto.CustomerDTO;
import com.cmcglobal.ebshop.dto.mapper.CustomerMapper;
import com.cmcglobal.ebshop.entity.Customer;
import com.cmcglobal.ebshop.exception.NotFoundException;
import com.cmcglobal.ebshop.repository.CustomerRepository;
import com.cmcglobal.ebshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(long id) {
        Optional<Customer> opCustomer = customerRepository.findById(id);
        if(opCustomer.isPresent()) {
            return customerMapper.toDto(opCustomer.get());
        }
        throw new NotFoundException("Customer id: " + id + " not found!");
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        customerRepository.save(customerMapper.toCustomer(customerDTO));
        return customerDTO;
    }

    @Override
    public CustomerDTO updateCustomerById(CustomerDTO customerDTO, long id) {
        Optional<Customer> opCustomer = customerRepository.findById(id);
        if(opCustomer.isPresent()) {
            customerRepository.save(customerMapper.toCustomer(customerDTO));
            return customerDTO;
        }
        throw new NotFoundException("Customer id: " + id + " not found!");
    }

    @Override
    public void deleteCustomerById(long id) {
        Optional<Customer> opCustomer = customerRepository.findById(id);
        if(opCustomer.isPresent()) {
            customerRepository.deleteById(id);
        }
        throw new NotFoundException("Customer id: " + id + " not found!");
    }
}
