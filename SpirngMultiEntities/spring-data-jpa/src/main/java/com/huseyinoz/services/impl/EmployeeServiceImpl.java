package com.huseyinoz.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huseyinoz.dto.DtoDepartment;
import com.huseyinoz.dto.DtoEmployee;
import com.huseyinoz.entites.Employee;
import com.huseyinoz.repository.EmployeeRepository;
import com.huseyinoz.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<DtoEmployee> findAllEmployees() {
		
		List<DtoEmployee> dtoEmployeeList = new ArrayList<>();
		
		List<Employee> employeeList = employeeRepository.findAll();
		if(employeeList!=null && !employeeList.isEmpty()) {
			for (Employee employee : employeeList) {
				
				DtoEmployee dtoEmployee = new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoEmployee);
				
				dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(),
						employee.getDepartment().getDepartmentName()));
				
				dtoEmployeeList.add(dtoEmployee);
			}
		}
		
		return null;
	}

}
