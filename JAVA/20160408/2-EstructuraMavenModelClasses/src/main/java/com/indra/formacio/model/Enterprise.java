package com.indra.formacio.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Enterprise {
	
	private ArrayList<Employee> empleadosEmpresa;
	private ArrayList<Customer> clientesEmpresa;
	private ArrayList<Product> productosEmpresa;
	private ArrayList<Sale> ventasEmpresa;
	
	public Enterprise(){
		this.empleadosEmpresa = new ArrayList<Employee>();
		this.clientesEmpresa = new ArrayList<Customer>();
		this.productosEmpresa = new ArrayList<Product>();
		this.ventasEmpresa = new ArrayList<Sale>();		
	}
	
	

	public Enterprise(ArrayList<Employee> empleadosEmpresa, ArrayList<Customer> clientesEmpresa,
			ArrayList<Product> productosEmpresa, ArrayList<Sale> ventasEmpresa) {
		this.empleadosEmpresa = empleadosEmpresa;
		this.clientesEmpresa = clientesEmpresa;
		this.productosEmpresa = productosEmpresa;
		this.ventasEmpresa = ventasEmpresa;
	}



	public ArrayList<Employee> getEmpleadosEmpresa() {
		return empleadosEmpresa;
	}

	public void setEmpleadosEmpresa(ArrayList<Employee> empleadosEmpresa) {
		this.empleadosEmpresa = empleadosEmpresa;
	}

	public ArrayList<Customer> getClientesEmpresa() {
		return clientesEmpresa;
	}

	public void setClientesEmpresa(ArrayList<Customer> clientesEmpresa) {
		this.clientesEmpresa = clientesEmpresa;
	}

	public ArrayList<Product> getProductosEmpresa() {
		return productosEmpresa;
	}

	public void setProductosEmpresa(ArrayList<Product> productosEmpresa) {
		this.productosEmpresa = productosEmpresa;
	}

	public ArrayList<Sale> getVentasEmpresa() {
		return ventasEmpresa;
	}

	public void setVentasEmpresa(ArrayList<Sale> ventasEmpresa) {
		this.ventasEmpresa = ventasEmpresa;
	}

    public void initialize(Integer [][] empCliProd){
    	
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
    
    public int getClientsPerEmpleat(Employee emp){
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
     public int getProductPerClient(Customer cust){
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
    public void actualizaPercentEmpleado() throws ParseException{
    	float totalClients=0,totalClientsPerEmpleat=0,total=0;
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    	totalClients=clientesEmpresa.size();
    	for (int i=0; i<clientesEmpresa.size();i++){
    		totalClientsPerEmpleat=getClientsPerEmpleat(clientesEmpresa.get(i).getEmployee());
    		total=totalClientsPerEmpleat/totalClients*100;
//    		System.out.println(total+" % de clients");
    		clientesEmpresa.get(i).getEmployee().setPercentCustomers(total);
    		clientesEmpresa.get(i).getEmployee().setPercentDate(sdf.parse("04/04/2016"))  ;  		
    	}
    }
    public void actualizaPercentClient() throws ParseException{
    	float totalProductes=0,totalProductesPerClient=0,total=0;
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    	totalProductes=clientesEmpresa.size();
    	for (int i=0; i<ventasEmpresa.size();i++){
    		totalProductesPerClient=getProductPerClient(ventasEmpresa.get(i).getCustomer());
    		total=totalProductesPerClient/totalProductes*100;
//    		System.out.println(total+" % de ventes");
    		ventasEmpresa.get(i).getCustomer().setPercentProduct (total);
    		ventasEmpresa.get(i).getCustomer().setPercentDate(sdf.parse("04/04/2016"))  ;  		
    	}
    }
    public void mostrarDatosClientes(){
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
	
	
}
