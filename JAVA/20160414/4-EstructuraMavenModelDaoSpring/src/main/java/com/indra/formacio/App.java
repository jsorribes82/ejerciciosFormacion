package com.indra.formacio;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indra.formacio.dao.CustomerRepository;
import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.dao.ProductRepository;
import com.indra.formacio.dao.SaleRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	Enterprise empresa = new Enterprise();
    	
    	empresa.setcRepo((CustomerRepository)context.getBean(CustomerRepository.class));
    	empresa.seteRepo((EmployeeRepository)context.getBean(EmployeeRepository.class));
    	empresa.setsRepo((SaleRepository)context.getBean(SaleRepository.class));
    	empresa.setpRepo((ProductRepository)context.getBean(ProductRepository.class));
    	
    	empresa.pintaEmpleats();
    	System.out.println("\n\n");
//    	empresa.pintaEmpleatsAntiguitat(10);
    	System.out.println("\n\n");
//    	empresa.pintaEmpleatsJubilacio(30);
//    	empresa.pintaEmpleatsSegonsEdat(26);
//    	empresa.jubilarEmpleado("Treballador 1", "Cognom treballador 1", "Treballador 2", "Cognom treballador 2");
//    	empresa.actualizarPercenClientes();
//    	empresa.mostrarClienteConMasProductos();
    	empresa.mostrarTodosClientesMaxCompradosPorProducto();
    	
    	
    	
        
    }
    
}
