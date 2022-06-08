package com.cmcglobal.ebshop.controller;

import com.cmcglobal.ebshop.dto.CustomerDTO;
import com.cmcglobal.ebshop.repository.CustomerRepository;
import com.cmcglobal.ebshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customersRes = customerService.getAllCustomers();
        return ResponseEntity.ok(customersRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable long id) {
        CustomerDTO customerRes = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerRes);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO customerRes = customerService.addCustomer(customerDTO);
        return ResponseEntity.ok(customerRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomerById(@Valid @RequestBody CustomerDTO customerDTO, @PathVariable long id) {
        CustomerDTO customerRes = customerService.updateCustomerById(customerDTO, id);
        return ResponseEntity.ok(customerRes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok("Delete success!");
    }
}
