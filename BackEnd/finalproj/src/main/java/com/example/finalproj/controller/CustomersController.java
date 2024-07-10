package com.example.finalproj.controller;

import com.example.finalproj.dto.CustomersDTO;
import com.example.finalproj.model.Customers;
import com.example.finalproj.service.CustomersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CustomersController {

    private final CustomersService customersService;

    @GetMapping
    public List<CustomersDTO> getAllCustomers() throws Exception {
        return customersService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customers getCustomerById(@PathVariable Long id) throws Exception {
        return customersService.getCustomerById(id);
    }

    @PostMapping
    public Customers createCustomer(@RequestBody CustomersDTO customersDTO) throws Exception {
        return customersService.createCustomer(customersDTO);
    }

    @PutMapping("/{id}")
    public CustomersDTO updateCustomer(@PathVariable Long id, @RequestBody CustomersDTO customersDTO) throws Exception {
        return customersService.updateCustomer(id, customersDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) throws Exception {
        customersService.deleteCustomer(id);
    }
}
