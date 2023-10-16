package com.santos.hexagonal.adapters.out;

import com.santos.hexagonal.adapters.out.repository.CustomerRepository;
import com.santos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.santos.hexagonal.application.core.domain.Customer;
import com.santos.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
