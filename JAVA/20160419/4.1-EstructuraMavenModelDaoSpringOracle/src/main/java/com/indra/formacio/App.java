package com.indra.formacio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indra.formacio.dao.CustomerRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	Enterprise empresa = new Enterprise();
    	
    	empresa.setcRepo((CustomerRepository)context.getBean(CustomerRepository.class));
    	
    	empresa.pintaEmpleats();
        
    }
}
