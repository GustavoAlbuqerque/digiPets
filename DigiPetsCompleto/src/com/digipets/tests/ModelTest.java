package com.digipets.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.digipets.controller.ExceptionDAO;
import com.digipets.model.Animal;
import com.digipets.model.Login;
import com.digipets.model.Tutor;
import com.digipets.model.Vacina;

public class ModelTest {
	
	boolean result = false;
	@Before
    public void setUp() throws Exception {
		Vacina vacina = new Vacina("VAC12", "10-05-2023", 1);
		if(vacina != null) {
			result = true;
		}
    }
	
	@Test
	public void CreateVacinaTrue() throws Exception {
		assertTrue(result);
	}
	
	@Test(expected = Exception.class)
	public void CreateVacinaException() throws Exception {
		Vacina vacina = new Vacina(null, null, 0);
	}
	
	@Test(expected = Exception.class)
	public void CreateTutorException() throws Exception {
		Tutor tutor = new Tutor(null, null, null);
	}
	
	@Test(expected = Exception.class)
	public void CreateAnimalException() throws Exception {
		Animal animal = new Animal(null, null, null, null, 0);
	}
	
	@Test
	public void LoginAssertEqualsFalse() throws ExceptionDAO, SQLException {
		Login login = new Login("xablau", "9012");
		boolean logado = login.autenticar();
		assertEquals(false, logado);
	}
	
	@Test
	public void LoginAssertEqualsTrue() throws ExceptionDAO, SQLException {
		Login login = new Login("admin", "admin");
		boolean logado = login.autenticar();
		assertEquals(true, logado);
	}

}



