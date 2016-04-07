package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
	
	public static ArrayList<Employee> empleadosEmpresa;
	public static ArrayList<Customer> clientesEmpresa;
	public static ArrayList<Product> productosEmpresa;
	public static ArrayList<Sale> ventasEmpresa;
	
    public static void main( String[] args ) throws ParseException
    {
        
    	initialize(new Integer [][] {{1,2},{3,4},{5,6,7,8}});
    	actualizaPercentEmpleado();
    	actualizaPercentClient();
    	mostrarDatosClientes();
    	
    	//Vuestro código!!!
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	Employee emp;
//        Customer cust;
//        Product prod;
//        Sale sal;
//        
//        long empCounter = 0, custCounter = 0, prodCounter = 0;
//        
//        Sale [] arraySale = new Sale[3];
//        
//        for (int i = 0; i<=arraySale.length; i ++){
//
//        	//Creamos el empleado con el constructor por defecto       	
//        	emp = new Employee();
//        	
//        	//Creamos el empleado con el nuevo constructor
////        	emp = new Employee(empCounter,"Nom empleat "+empCounter, "Cognom empleat"+empCounter,"01/01/1970");
////        	empCounter++;
//
////        	Opción básica
////        	emp.setId(empCounter);
////        	empCounter=empCounter+1;
//        	emp.setId(empCounter++);
//        	emp.setName("Empleat "+emp.getId());
//
////        	Creamos el cliente
//        	cust = new Customer();
//        	cust.setId(custCounter++);
//        	cust.setName("Cliente "+cust.getId());
////        	seteamos el empleado
//        	cust.setEmployee(emp);
//        	
////        	Creamos el producto
//        	prod = new Product();
//        	prod.setId(prodCounter++);
//        	prod.setName("Producto "+prod.getId());
//        	
////        	Asociamos producto y cliente
//        	sal = new Sale(prod,cust);
//        	
//        	arraySale[i] = sal;
//        }

//        for (int i = 0; i < arraySale.length; i++) {
//			sal = arraySale[i];
//			print("Nombre del producto: " + sal.getProduct().getName());
//			System.out.println("	Nombre del cliente: " + sal.getCustomer().getName() + " que lo gestiona el empleado " + sal.getCustomer().getEmployee().getName());
//        }
               
//        for (Sale sale : arraySale) {
//			System.out.println("Nombre del producto: " + sale.getProduct().getName());
//			System.out.println("	Nombre del cliente: " + sale.getCustomer().getName() + " que lo gestiona el empleado " + sale.getCustomer().getEmployee().getName());
//		}
        
    }
    
    
    static void print(String entrada){
    	System.out.println(entrada);
    }
    
     public static int clientsPerEmpleat(Employee emp){
    	int total=0;
    	for (int i=0; i<empleadosEmpresa.size(); i++){
    		for (int j=0; j<clientesEmpresa.size();j++){
			if (clientesEmpresa.get(j).getEmployee().getId()==empleadosEmpresa.get(i).getId()){
				total=i+1;
			}
    		}
    	}
    	return total;
    }
     public static int productPerClient(Customer cust){
     	int total=0;
     	for (int i=0; i<ventasEmpresa.size(); i++){
 			if (ventasEmpresa.get(i).getCustomer().equals(cust)){
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
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    	totalClients=clientesEmpresa.size();
    	for (int i=0; i<clientesEmpresa.size();i++){
    		totalClientsPerEmpleat=clientsPerEmpleat(clientesEmpresa.get(i).getEmployee());
    		total=totalClientsPerEmpleat/totalClients*100;
    		System.out.println(total+" % de clients");
    		clientesEmpresa.get(i).getEmployee().setPercentCustomers(total);
    		clientesEmpresa.get(i).getEmployee().setPercentDate(sdf.parse("04/04/2016"))  ;  		
    	}
    }
    public static  void actualizaPercentClient() throws ParseException{
    	float totalProductes=0,totalProductesPerClient=0,total=0;
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    	totalProductes=ventasEmpresa.size();
    	for (int i=0; i<ventasEmpresa.size();i++){
    		totalProductesPerClient=productPerClient(ventasEmpresa.get(i).getCustomer());
    		total=totalProductesPerClient/totalProductes*100;
    		System.out.println(total+" % de ventes");
    		ventasEmpresa.get(i).getCustomer().setPercentProduct (total);
    		ventasEmpresa.get(i).getCustomer().setPercentDate(sdf.parse("04/04/2016"))  ;  		
    	}
    }
    public static void mostrarDatosClientes(){
    	for (int i=0; i<empleadosEmpresa.size();i++){
    		System.out.println("-<"+empleadosEmpresa.get(i).getName()+">");
    		System.out.println("-Porcentaje de clientes: "+empleadosEmpresa.get(i).getPercentCustomers());
    		System.out.println("-Clientes: ");
    		for (int j=0; j<clientesEmpresa.size();j++){
    			if (empleadosEmpresa.get(i).getId()==clientesEmpresa.get(j).getEmployee().getId()){
        		System.out.println("	-<"+clientesEmpresa.get(j).getName()+">"+", Porcentaje de productos: <"+clientesEmpresa.get(j).getPercentProduct()+">");
				for (int k=0; k<ventasEmpresa.size();k++){
    				if (ventasEmpresa.get(k).getCustomer().getId()==clientesEmpresa.get(j).getId()){
        				System.out.println("		-<"+ventasEmpresa.get(k).getProduct().getName()+">");
	    				
    				}
    				
    			}
    			}
    		}
    	}
    }
    private static void initialize(Integer [][] empCliProd){
    	empleadosEmpresa = new ArrayList<Employee>();
    	clientesEmpresa = new ArrayList<Customer>();
    	productosEmpresa = new ArrayList<Product>();
    	ventasEmpresa = new ArrayList<Sale>();
    	
    	Employee e;
    	Customer c;
    	int numProduct;
    	Product p;
    	Sale s;
    	
    	for (int i = 0; i < empCliProd.length; i++) {
			e = new Employee();
			e.setId(new Long(i));
			e.setName("Empleado "+i);
			empleadosEmpresa.add(e);
			for (int j = 0; j < empCliProd[i].length; j++) {
				c = new Customer();
				c.setId(new Long(j));
				c.setName("Cliente " +j+ " del empleado "+i);
				c.setEmployee(e);
				clientesEmpresa.add(c);
				numProduct = empCliProd[i][j];
				for (int k = 0; k < numProduct; k++) {
					p = new Product();
					p.setId(new Long(k));
					p.setName("Producto " +k + " del "+c.getName());
					productosEmpresa.add(p);
					s = new Sale(p,c);
					ventasEmpresa.add(s);
				}
			}
		}
    	
    }

	}