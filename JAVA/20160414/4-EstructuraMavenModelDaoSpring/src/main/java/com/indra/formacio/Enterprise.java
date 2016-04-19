package com.indra.formacio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacio.dao.CustomerRepository;
import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.dao.ProductRepository;
import com.indra.formacio.dao.SaleRepository;
import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

public class Enterprise {

	@Autowired
	CustomerRepository cRepo;
	@Autowired
	EmployeeRepository eRepo;
	@Autowired
	SaleRepository sRepo;
	@Autowired
	ProductRepository pRepo;
	
	public void pintaEmpleats(){
		System.out.println(cRepo.count());
	}

	public CustomerRepository getcRepo() {
		return cRepo;
	}

	public void setcRepo(CustomerRepository cRepo) {
		this.cRepo = cRepo;
	}
	public EmployeeRepository geteRepo() {
		return eRepo;
	}

	public void seteRepo(EmployeeRepository eRepo) {
		this.eRepo = eRepo;
	}
	public void pintaEmpleatsAntiguitat(int anys){
		System.out.println(eRepo.findByEmpIniciDesdeHoyHasta(anys)	);	
	}
	
	public void pintaEmpleatsJubilacio(int edatJubilacio){
		System.out.println(eRepo.findByJubilan(edatJubilacio));
	}
	public void pintaEmpleatsSegonsEdat(int edad){
		System.out.println(eRepo.findByEdad(edad));
	}
	public void jubilarEmpleado(String nomJubilado, String surnameJubilado, String nomSinJubilar, String surnameSinJubilar){
		Employee emp1=eRepo.findByNomYCognom(nomSinJubilar,surnameSinJubilar);
		Employee empJub=eRepo.findByNomYCognom(nomJubilado,surnameJubilado);
		List<Customer> custList=cRepo.findCustomerListByEmployee(empJub);
		
		for (int i = 0; i < custList.size(); i++) {
			custList.get(i).setEmployee(emp1);
			cRepo.save(custList.get(i));
			System.out.println(custList.get(i).getName());
		}
//		System.out.println(eRepo.count()+"Total empleados");
		eRepo.delete(empJub);
//		System.out.println(eRepo.count()+"Total empleados");
		Double percCustom=eRepo.actualizaPorcentagesEmpleados(emp1);
		emp1.setPercentCustomers(percCustom);
		emp1.setPercentDate(new Date());
		eRepo.save(emp1);
		System.out.println(emp1.getPercentCustomers());
	}
	public void actualizarPercenClientes(){
		List<Customer> custList=cRepo.findListAllCustomer();
		for (int i = 0; i < custList.size(); i++) {
//			custList.get(i).setPercentProduct(vRepo.actualizaPorcentagesClientes(custList.get(i)));
			Double total=sRepo.actualizaPorcentagesClientes(custList.get(i));
			custList.get(i).setPercentProduct(total);
//			custList.get(i).setPercentDate(new Date());
			cRepo.save(custList.get(i));
			System.out.println(custList.get(i).getPercentProduct());
//			cRepo.save(custList.get(i));
		}
		
	}
	public void mostrarClienteConMasProductos(){
		List<Customer> custList=(List<Customer>) cRepo.findAll();
		System.out.println(sRepo.clienteMasProductos(custList));
		
	}
	public void mostrarTodosClientesMaxCompradosPorProducto(){
		List<Product> productList=(List<Product>) pRepo.findAll();
		for (int j = 0; j < productList.size(); j++) {
			System.out.println("\tProducto "+productList.get(j).getName());
			List<Sale> saleList=sRepo.findByKey_ProductOrderByCantidadDesc(productList.get(j));
			for (int i = 0; i < saleList.size(); i++) {
				if(i==0){
					System.out.println("Cliente "+saleList.get(i).getCustomer().getName()+"\t\tCantidad "+saleList.get(i).getCantidad());
					}			
			}
		}
	}
	public void setsRepo(SaleRepository sRepo) {
		this.sRepo = sRepo;
		
	}

	public void setpRepo(ProductRepository pRepo) {
		this.pRepo=pRepo;
		
	}
}
