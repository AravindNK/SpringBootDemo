package com.example.app.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.app.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	@Override
	List<Employee> findAll();
}
