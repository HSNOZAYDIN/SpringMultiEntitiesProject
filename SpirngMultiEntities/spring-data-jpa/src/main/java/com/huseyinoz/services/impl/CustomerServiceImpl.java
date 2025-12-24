package com.huseyinoz.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huseyinoz.dto.DtoAddress;
import com.huseyinoz.dto.DtoCustomer;
import com.huseyinoz.entites.Address;
import com.huseyinoz.entites.Customer;
import com.huseyinoz.repository.CustomerRepository;
import com.huseyinoz.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public DtoCustomer findCustomerById(Long id) {
		
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress  dtoAddress  = new DtoAddress();
		
		customerRepository.findById(id);
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isEmpty()) {
		return null;
		}
		
		Customer customer = optional.get();
		Address address = optional.get().getAddress();
		
		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAddress);
		
		dtoCustomer.setAddress(dtoAddress);
		
		return dtoCustomer;
	}

	
	
	
	
	
}
