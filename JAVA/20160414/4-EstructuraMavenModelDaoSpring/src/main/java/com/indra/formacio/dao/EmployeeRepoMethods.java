package com.indra.formacio.dao;

import java.util.List;

import com.indra.formacio.model.Employee;

public interface EmployeeRepoMethods  {
	List<Employee> findByEmpIniciDesdeHoyHasta(int totalAnyos);
	List<Employee> findByJubilan(int edatJubilacion);
	List<Employee> findByEdad(int edad);
	Employee findByNomYCognom(String nom, String cognom);
	Double actualizaPorcentagesEmpleados(Employee emp1);
}
