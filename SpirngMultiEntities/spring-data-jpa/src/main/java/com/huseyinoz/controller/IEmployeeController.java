package com.huseyinoz.controller;

import java.util.List;

import com.huseyinoz.dto.DtoEmployee;

public interface IEmployeeController {

	public List<DtoEmployee> findAllEmployees();
	
}
