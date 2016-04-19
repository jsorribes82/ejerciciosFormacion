package com.indra.formacio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import junit.framework.TestCase;

import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContextTest.xml" })
public class EmployeeRepoTest extends TestCase {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	EmployeeRepository erepo;
	
	
	@Test
	public void testFileInsertedData() throws ParseException {
		List<Employee> res = erepo.findByName("Treballador 3");
		assertFalse(res.isEmpty());
		
		Employee e = res.get(0);
		
		assertEquals(sdf.parse("01/10/1970"), sdf.parse(sdf.format(e.getBirthday())));
	}
}
