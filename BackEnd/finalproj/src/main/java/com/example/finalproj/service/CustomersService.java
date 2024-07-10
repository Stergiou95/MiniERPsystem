package com.example.finalproj.service;

import com.example.finalproj.dto.CustomersDTO;
import com.example.finalproj.model.Customers;

import java.util.List;

public interface CustomersService {

    Customers createCustomer(CustomersDTO customersDTO) throws Exception;
    CustomersDTO updateCustomer(Long customerId, CustomersDTO customersDTO) throws Exception;
    void deleteCustomer(Long customerId) throws Exception;
    Customers getCustomerById(Long customerId) throws Exception;
    List<CustomersDTO> getAllCustomers() throws Exception;
}
