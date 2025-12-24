package com.huseyinoz.services;

import com.huseyinoz.dto.DtoCustomer;

public interface ICustomerService {

	
	public DtoCustomer findCustomerById(Long id);
}
