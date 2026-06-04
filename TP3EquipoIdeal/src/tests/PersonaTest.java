package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import logica.Persona;

public class PersonaTest {

	@Test
	public void testPersonaCreadaValida() {
		Persona p = new Persona("Juan", "Lopez", 3, "PROGRAMADOR");
		assertEquals("Juan", p.getNombre());
		assertEquals("Lopez", p.getApellido());
		assertEquals(3, p.getCalificacion());
		assertEquals("PROGRAMADOR", p.getRol());
	}

	@Test
	public void testEqualsDistintaPersona() {
		Persona p1 = new Persona("Juan", "Lopez", 3, "PROGRAMADOR");
		Persona p2 = new Persona("Pedro", "Lopez", 3, "PROGRAMADOR");
		assertNotEquals(p1, p2);
	}

}
