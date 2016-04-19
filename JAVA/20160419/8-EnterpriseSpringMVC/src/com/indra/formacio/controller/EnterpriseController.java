package com.indra.formacio.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.indra.formacio.dao.CustomerRepository;
import com.indra.formacio.dao.EmployeeRepository;
 
@Controller
public class EnterpriseController {
 
	@Autowired
	EmployeeRepository eRepo;
	
	@Autowired
	CustomerRepository cRepo;
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		
		long numEmp = eRepo.count();
		
		long numCli = cRepo.count();
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Número empleats: "+numEmp+"**********</h3></div>";
		
		message += "<br><div style='text-align:center;'>"
				+ "<h3>********** Número clients: "+numCli+"**********</h3></div>";
		
		message += "<br>This message is coming from EnterpriseController.java<br>";
		return new ModelAndView("welcome", "message", message);
	}
}