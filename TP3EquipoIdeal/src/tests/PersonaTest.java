package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import logica.Persona;

public class PersonaTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void calificacionMenorAlRangoTest() {
		@SuppressWarnings("unused")
		Persona p = new Persona ("Juan", "Lopez", 0, "PROGRAMADOR");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void calificacionMayorAlRangoTest() {
		@SuppressWarnings("unused")
		Persona p = new Persona ("Juan", "Lopez", 6, "PROGRAMADOR");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void rolNoValidoTest() {
		@SuppressWarnings("unused")
		Persona p = new Persona ("Juan", "Lopez", 5, "ASISTENTE");
	}

	@Test
	public void personaCreadaValidaTest() {
		Persona p = new Persona("Juan", "Lopez", 3, "PROGRAMADOR");
		assertEquals("Juan", p.getNombre());
		assertEquals("Lopez", p.getApellido());
		assertEquals(3, p.getCalificacion());
		assertEquals("PROGRAMADOR", p.getRol());
	}

	@Test
	public void distintaPersonaTest() {
		Persona p1 = new Persona("Juan", "Lopez", 3, "PROGRAMADOR");
		Persona p2 = new Persona("Pedro", "Lopez", 3, "PROGRAMADOR");
		assertNotEquals(p1, p2);
	}

}
