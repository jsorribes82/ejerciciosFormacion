package com.indra.formacio.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.indra.formacio.model.Employee;

public interface EmployeeRepository  extends CrudRepository<Employee, Long> {
	List<Employee> findByName(String name);
}
