package com.indra.formacio;

import java.text.ParseException;

import com.indra.formacio.model.Enterprise;

import junit.framework.TestCase;

public class EnterpriseTest extends TestCase {
	public void testerInitialitzate(){
		
		Enterprise empresa=new Enterprise();
		empresa.initialize(new Integer[][] {{1,2},{3,4}});
		
		assertEquals(10, empresa.getProductosEmpresa().size());
		assertEquals(4, empresa.getClientesEmpresa().size());
		assertEquals(2, empresa.getEmpleadosEmpresa().size());
		assertEquals(10, empresa.getVentasEmpresa().size());
		assertEquals("Cliente 0 del empleado 0", empresa.getClientesEmpresa().get(0).getName());
		assertEquals("Empleado 0", empresa.getEmpleadosEmpresa().get(0).getName());
		
	}
	public void testerActualizaPercentEmpleado() throws ParseException{
		Enterprise empresa=new Enterprise();
		empresa.initialize(new Integer[][] {{1,2},{3,4}});
		empresa.actualizaPercentEmpleado();
		
		assertEquals(50.0f, empresa.getEmpleadosEmpresa().get(0).getPercentCustomers());
		
	}
	public void testerActualizaPercentCliente() throws ParseException{
		Enterprise empresa=new Enterprise();
		empresa.initialize(new Integer[][] {{1,2},{3,4}});
		empresa.actualizaPercentClient();
		
		assertEquals(10.0f, empresa.getClientesEmpresa().get(0).getPercentProduct());
		
	}
}
