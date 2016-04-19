package com.indra.formacio.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacio.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepoMethods{
	@Autowired	//Spring Annotation
	
	
	protected EntityManager entityManager;
	@SuppressWarnings("unchecked")
	
	public List<Employee> findByEmpIniciDesdeHoyHasta(int totalAnyos){
		Date now= Calendar.getInstance().getTime();
		Calendar nowBefore=Calendar.getInstance();
		nowBefore.add(Calendar.YEAR, -1*totalAnyos);
		Query q = entityManager.createQuery("FROM Employee e WHERE e.dateStart between  :totalAnyos AND :dataActual ");
		q.setParameter("dataActual", now);
		q.setParameter("totalAnyos", nowBefore.getTime());
		return (List<Employee>)q.getResultList();
		
	};
	public List<Employee> findByJubilan(int edatJubilacion){
		Calendar nowBefore=Calendar.getInstance();
		nowBefore.add(Calendar.YEAR, -1*edatJubilacion);
		Query q = entityManager.createQuery("FROM Employee e WHERE e.birthday <=  :totalAnyos");
		q.setParameter("totalAnyos", nowBefore.getTime());
		return (List<Employee>)q.getResultList();
		
	};
	
	public List<Employee> findByEdad(int edad){
		Calendar nowBeforeBefore= Calendar.getInstance();
		Calendar nowBefore=Calendar.getInstance();
		nowBefore.add(Calendar.YEAR, -1*edad+1);
		nowBeforeBefore.add(Calendar.YEAR, -1*edad);
		Query q = entityManager.createQuery("FROM Employee e WHERE e.birthday between  :dataActual AND :totalAnyos   ");
		q.setParameter("dataActual", nowBeforeBefore.getTime());
		q.setParameter("totalAnyos", nowBefore.getTime());
		return (List<Employee>)q.getResultList();
		
	};
	public Employee findByNomYCognom(String nom, String cognom){
		Query q = entityManager.createQuery("FROM Employee e WHERE e.name=:nom AND e.surname=:cognom");
		q.setParameter("nom", nom);
		q.setParameter("cognom", cognom);
		return (Employee)q.getSingleResult();
	};
	
	public Double actualizaPorcentagesEmpleados(Employee emp1){
		
		
		Query q = entityManager.createQuery("select count(*) FROM Customer c");
		Long totalEmpleados=(Long)q.getSingleResult();
		Query q2 = entityManager.createQuery("select count(*) FROM Customer c where c.employee.id=:empleado");
		q2.setParameter("empleado", emp1.getId());
		
		Long totalEmpleadosPorCliente=(Long)q2.getSingleResult();
		Double percentCustomers=(double) (((double)totalEmpleadosPorCliente)/totalEmpleados)*100;
		return percentCustomers;
		
	}
	
}
