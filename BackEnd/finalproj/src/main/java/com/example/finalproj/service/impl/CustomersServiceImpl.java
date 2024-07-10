package com.example.finalproj.service.impl;

import com.example.finalproj.dto.CustomersDTO;
import com.example.finalproj.mapper.CustomersMapper;
import com.example.finalproj.model.Customers;
import com.example.finalproj.repository.CustomersRepository;
import com.example.finalproj.repository.LocationsRepository;
import com.example.finalproj.service.CustomersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CustomersServiceImpl implements CustomersService {

    private final CustomersRepository customersRepository;
    private final CustomersMapper customersMapper;
    private final LocationsRepository locationsRepository;

    @Override
    public Customers createCustomer(CustomersDTO customersDTO) throws Exception {
        Customers customer = customersMapper.toEntity(customersDTO);
        customer.setLocation(locationsRepository.findById(customersDTO.getLocationID()).orElseThrow(() -> new RuntimeException("Location not found")));
        return customersRepository.save(customer);
    }

    @Override
    public CustomersDTO updateCustomer(Long customerId, CustomersDTO customersDTO) throws Exception {
        try{
            Customers existingCustomer = customersRepository.findById(customerId)
                    .orElseThrow(() -> new RuntimeException("Customer not found"));

            existingCustomer.setCompanyName(customersDTO.getCompanyName());
            existingCustomer.setEmail(customersDTO.getEmail());
            existingCustomer.setLocation(customersMapper.toEntity(customersDTO).getLocation());

            customersRepository.save(existingCustomer);

            log.info("Customer updated successfully : {}", customersDTO);
            return customersMapper.toDTO(existingCustomer);
        } catch (RuntimeException e) {
            log.error("error while updating customer : {}", customersDTO, e);
            throw e;
        }catch (Exception e) {
            log.error("Unexpected error while updating customer with id {}", customerId, e);
            throw new RuntimeException("An unexpected error occurred while updating the customer", e);
        }

    }

    @Override
    public void deleteCustomer(Long customerId) throws Exception {
        if (!customersRepository.existsById(customerId)) {
            throw new RuntimeException("Customer not found with id: " + customerId);
        }
        customersRepository.deleteById(customerId);
    }

    @Override
    public Customers getCustomerById(Long customerId) throws Exception {
        return customersRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
    }

    @Override
    public List<CustomersDTO> getAllCustomers() throws Exception {
        List<Customers> customersList = customersRepository.findAll();
        return customersList.stream()
                .map(customersMapper::toDTO)
                .collect(Collectors.toList());    }
}
