package com.indra.formacio;


import java.text.ParseException;
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
	
    public static void main( String[] args ) throws ParseException
    {
    	EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
    	
    	initialize(manager,new Integer [][] {{1,2},{3,4},{5,6,7,8}});
    	actualizaPercentEmpleado(manager);
    	actualizaPercentClient(manager);
    	mostrarDatosClientes(manager);
    	
    	
		
    }
    public static int clientsPerEmpleat(EntityManager manager,Employee emp){
    	List clientesEmpresa= manager.createQuery(
		        "FROM Customer c "
    			+"WHERE c.employee.id=:empID")
    			.setParameter("empID", emp.getId())
		        .getResultList();
    	return clientesEmpresa.size();
    }
    
     public static int productPerClient(EntityManager manager,Customer cust){
    	List productClient= manager.createQuery(
		        "FROM Sale s "
    			+"WHERE s.customer.id=:idProd")
    			.setParameter("idProd", cust.getId())
		        .getResultList();
     	return productClient.size();
     }
    /**
     * actualiza Percentatge de Clients per Empleat
     * @param clientesEmpresa
     * @throws ParseException 
     */
    public static  void actualizaPercentEmpleado(EntityManager manager) throws ParseException{
    	float totalClients=0,totalClientsPerEmpleat=0,total=0;
//    	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    	List empleadosEmpresa = manager.createQuery(
		        "FROM Employee e ")
		        .getResultList();
    	List clientesEmpresa= manager.createQuery(
		        "FROM Customer c ")
		        .getResultList();
    	totalClients=clientesEmpresa.size();
    	Employee empAux;
    	manager.getTransaction().begin();
		for (int i=0; i<empleadosEmpresa.size();i++){
			empAux=(Employee)empleadosEmpresa.get(i);
    		totalClientsPerEmpleat=clientsPerEmpleat(manager,empAux);
    		total=totalClientsPerEmpleat/totalClients*100;
//    		System.out.println(total+" % de clients");
    		empAux.setPercentCustomers(total);
    		empAux.setPercentDate(new Date())  ;  	
//    		System.out.println(sdf.format(custAux.getEmployee().getPercentDate()));
    		manager.persist(empAux);
    	}
		manager.getTransaction().commit();
		
    }
    public static  void actualizaPercentClient(EntityManager manager) throws ParseException{
    	float totalProductes=0,totalProductesPerClient=0,total=0;
//    	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    	List clientesEmpresa= manager.createQuery(
		        "FROM Customer c ")
		        .getResultList();
    	List productos= manager.createQuery(
		        "FROM Product p ")
		        .getResultList();
    	totalProductes=productos.size();
    	Customer custAux;
    	manager.getTransaction().begin();
    	for (int i=0; i<clientesEmpresa.size();i++){
    		custAux=(Customer)clientesEmpresa.get(i);
    		totalProductesPerClient=productPerClient(manager,custAux);
    		total=totalProductesPerClient/totalProductes*100;
//    		System.out.println("Cliente: "+custAux.getName() +"   "+total+" % de ventes");
    		custAux.setPercentProduct (total);
    		custAux.setPercentDate(new Date())  ; 
    		manager.persist(custAux);
    	}
    	manager.getTransaction().commit();
    }
    public static void mostrarDatosClientes(EntityManager manager){
    	List empleadosEmpresa = manager.createQuery(
		        "SELECT e FROM Employee e ")
		        .getResultList();
    	Employee empAux;
    	Customer custAux;
    	Sale ventaAux;
    	for (int i=0; i<empleadosEmpresa.size();i++){
    		empAux = (Employee) empleadosEmpresa.get(i);
    		List clientesEmpresa= manager.createQuery(
    		        "FROM Customer c "
    				+"WHERE c.employee.id=:empID")
    				.setParameter("empID", empAux.getId() )
    		        .getResultList();
    		System.out.println("-<"+empAux.getName()+">");
    		System.out.println("-Porcentaje de clientes: "+empAux.getPercentCustomers());
    		System.out.println("-Clientes: ");
    		for (int j=0; j<clientesEmpresa.size();j++){
    			custAux=(Customer)clientesEmpresa.get(j);
    			List ventasEmpresa= manager.createQuery(
    			        "FROM Sale s "
    					+"WHERE s.customer.id=:custID")
    					.setParameter("custID", custAux.getId() )
    			        .getResultList();
        			System.out.println("	-<"+custAux.getName()+">");
    				System.out.println("	-<"+custAux.getName()+">"+", Porcentaje de productos: <"+custAux.getPercentProduct()+">");
					for (int k=0; k<ventasEmpresa.size();k++){
						ventaAux=(Sale)ventasEmpresa.get(k);
	        				System.out.println("		-<"+ventaAux.getProduct().getName()+">");
		    				
    				
					}
    		}
    	}
    }

	private static void initialize(EntityManager manager,Integer[][] empCliProd) {
    	Employee e;
    	Customer c;
    	int numProduct;
    	Product p;
    	Sale s;
    	for (int i = 0; i < empCliProd.length; i++) {
    		manager.getTransaction().begin();
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
			manager.getTransaction().commit();	
		}
	}
}
