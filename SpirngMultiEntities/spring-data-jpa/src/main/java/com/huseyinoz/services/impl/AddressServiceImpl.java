package com.huseyinoz.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huseyinoz.dto.DtoAddress;
import com.huseyinoz.dto.DtoCustomer;
import com.huseyinoz.entites.Address;
import com.huseyinoz.repository.AddressRepository;
import com.huseyinoz.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public DtoAddress findAddressById (Long id) {
		
		DtoAddress dtoAddress = new DtoAddress();

	Optional<Address> optional = addressRepository.findById(id);
	
	if (optional.isEmpty()) {
		return null;
	}
		Address address = optional.get();
		
		BeanUtils.copyProperties(dtoAddress, address);
		
        DtoCustomer dtoCustomer = new DtoCustomer();
        dtoCustomer.setId(address.getCustomer().getId());
        dtoCustomer.setName(address.getCustomer().getName());
        dtoCustomer.setAddress(dtoAddress);
		
//        dtoAddress.setCustomer(dtoCustomer);
        
        
		return dtoAddress;
	}
	
	

}
