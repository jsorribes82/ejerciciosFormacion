package com.indra.formacio;

import java.text.ParseException;

import com.indra.formacio.model.Enterprise;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws ParseException
    {
        
    	Enterprise ent = new Enterprise();
    	
    	ent.initialize(new Integer [][] {{1,2},{3,4},{5,6,7,8}});
    	ent.actualizaPercentEmpleado();
    	ent.actualizaPercentClient();
    	ent.mostrarDatosClientes();
        
    	}
    

	}