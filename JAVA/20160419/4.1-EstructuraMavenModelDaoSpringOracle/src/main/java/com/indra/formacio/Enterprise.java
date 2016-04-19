package com.indra.formacio;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacio.dao.CustomerRepository;

public class Enterprise {

	@Autowired
	CustomerRepository cRepo;
	
	public void pintaEmpleats(){
		System.out.println(cRepo.count());
	}

	public CustomerRepository getcRepo() {
		return cRepo;
	}

	public void setcRepo(CustomerRepository cRepo) {
		this.cRepo = cRepo;
	}
	
	
	
}
