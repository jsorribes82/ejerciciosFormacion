package com.indra.formacio;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

/**
 * Hello world!
 *
 */
public class App 
{
	public static EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
	
    public static void main( String[] args ) throws ParseException
    {
    	initialize(new Integer [][] {{1,2},{3,4},{5,6,7,8}});
    	actualizaPercentEmpleado();
    	actualizaPercentClient();
    	mostrarDatosClientes();
    	
    	
		
    }
    public static int clientsPerEmpleat(Employee emp){
    	int total=0;
    	List empleadosEmpresa = manager.createQuery(
		        "SELECT e FROM Employee e ")
		        .getResultList();
    	List clientesEmpresa= manager.createQuery(
		        "FROM Customer c ")
		        .getResultList();
    	for (int i=0; i<empleadosEmpresa.size(); i++){
    		for (int j=0; j<clientesEmpresa.size();j++){
    			Employee empAux = (Employee) empleadosEmpresa.get(i);
        		Customer custAux=(Customer)clientesEmpresa.get(j);
			if (custAux.getId()==empAux.getId()){
				total=i+1;
			}
    		}
    	}
    	return total;
    }
    
     public static int productPerClient(Customer cust){
     	int total=0;
    	List ventasEmpresa= manager.createQuery(
		        "FROM Sale s ")
		        .getResultList();
     	for (int i=0; i<ventasEmpresa.size(); i++){
     		Sale ventaAux=(Sale)ventasEmpresa.get(i);
 			if (ventaAux.getCustomer().equals(cust)){
 				total=i+1;
 			}
 		}
     	return total;
     }
    /**
     * actualiza Percentatge de Clients per Empleat
     * @param clientesEmpresa
     * @throws ParseException 
     */
    public static  void actualizaPercentEmpleado() throws ParseException{
    	float totalClients=0,totalClientsPerEmpleat=0,total=0;
    	Date date = new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    	String fecha = sdf.format(date);
    	List empleadosEmpresa = manager.createQuery(
		        "SELECT e FROM Employee e ")
		        .getResultList();
    	List clientesEmpresa= manager.createQuery(
		        "FROM Customer c ")
		        .getResultList();
    	totalClients=clientesEmpresa.size();
    	for (int i=0; i<clientesEmpresa.size();i++){
    		Customer custAux=(Customer)clientesEmpresa.get(i);
    		totalClientsPerEmpleat=clientsPerEmpleat(custAux.getEmployee());
    		total=totalClientsPerEmpleat/totalClients*100;
//    		System.out.println(total+" % de clients");
    		custAux.getEmployee().setPercentCustomers(total);
    		custAux.getEmployee().setPercentDate(sdf.parse(fecha))  ;  	
//    		System.out.println(sdf.format(custAux.getEmployee().getPercentDate()));
    	}
    }
    public static  void actualizaPercentClient() throws ParseException{
    	float totalProductes=0,totalProductesPerClient=0,total=0;
    	Date date = new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    	String fecha = sdf.format(date);
    	List ventasEmpresa= manager.createQuery(
		        "FROM Sale s ")
		        .getResultList();
    	List productos= manager.createQuery(
		        "FROM Product p ")
		        .getResultList();
    	totalProductes=productos.size();
    	for (int i=0; i<ventasEmpresa.size();i++){
    		Sale ventaAux=(Sale)ventasEmpresa.get(i);
    		totalProductesPerClient=productPerClient(ventaAux.getCustomer());
    		total=totalProductesPerClient/totalProductes*100;
//    		System.out.println(total+" % de ventes");
    		ventaAux.getCustomer().setPercentProduct (total);
    		ventaAux.getCustomer().setPercentDate(sdf.parse(fecha))  ;  		
    	}
    }
    public static void mostrarDatosClientes(){
    	List empleadosEmpresa = manager.createQuery(
		        "SELECT e FROM Employee e ")
		        .getResultList();
    	List clientesEmpresa= manager.createQuery(
		        "FROM Customer c ")
		        .getResultList();
    	List ventasEmpresa= manager.createQuery(
		        "FROM Sale s ")
		        .getResultList();
    	for (int i=0; i<empleadosEmpresa.size();i++){
    		Employee empAux = (Employee) empleadosEmpresa.get(i);
    		System.out.println("-<"+empAux.getName()+">");
    		System.out.println("-Porcentaje de clientes: "+empAux.getPercentCustomers());
    		System.out.println("-Clientes: ");
    		for (int j=0; j<clientesEmpresa.size();j++){
    			Customer custAux=(Customer)clientesEmpresa.get(j); 
    			if (empAux.getId()==custAux.getEmployee().getId()){
        			System.out.println("	-<"+custAux.getName()+">");
    				System.out.println("	-<"+custAux.getName()+">"+", Porcentaje de productos: <"+custAux.getPercentProduct()+">");
					for (int k=0; k<ventasEmpresa.size();k++){
						Sale ventaAux=(Sale)ventasEmpresa.get(k);
	    				if (ventaAux.getCustomer().getId()==custAux.getId()){
	        				System.out.println("		-<"+ventaAux.getProduct().getName()+">");
		    				
	    				}
    				
    			}
    			}
    		}
    	}
    }

	private static void initialize(Integer[][] empCliProd) {
    	Employee e;
    	Customer c;
    	int numProduct;
    	Product p;
    	Sale s;
		manager.getTransaction().begin();
		
    	for (int i = 0; i < empCliProd.length; i++) {
			e = new Employee();
			e.setName("Empleado "+i);
			manager.persist(e);
			for (int j = 0; j < empCliProd[i].length; j++) {
				c = new Customer();
				c.setName("Cliente " +j+ " del empleado "+i);
				c.setEmployee(e);
				manager.persist(c);
				manager.refresh(e);
				numProduct = empCliProd[i][j];
				for (int k = 0; k < numProduct; k++) {
					p = new Product();
					p.setName("Producto " +k + " del "+c.getName());
					manager.persist(p);
					manager.refresh(e);
					manager.refresh(c);
					s = new Sale(p,c);
					manager.persist(s);
				}
			}
			
		}
    	manager.getTransaction().commit();
		
	}
}
