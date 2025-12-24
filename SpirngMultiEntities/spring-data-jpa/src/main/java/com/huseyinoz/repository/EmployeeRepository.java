package com.huseyinoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huseyinoz.entites.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
