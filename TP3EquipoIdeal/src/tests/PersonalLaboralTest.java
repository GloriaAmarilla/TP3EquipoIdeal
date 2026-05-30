package tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import logica.Persona;
import logica.PersonalLaboral;

public class PersonalLaboralTest {

	@Test
	public void cargarPersonaTest() {
		
		Persona persona = new Persona("Cristian","Bier",4,"Lider");
		PersonalLaboral personal = new PersonalLaboral();
		personal.cargarPersona(persona);

		assertEquals(1,personal.getPersonas().size());
	}
	
	@Test
	public void peronsalIncompatibleTest() {
		
		Persona persona = new Persona("Cristian","Bier",4,"Lider");
		Persona persona2 = new Persona("Pepito","guayaba",2,"Programador");
		
		PersonalLaboral personal = new PersonalLaboral();
		personal.cargarPersona(persona);
		personal.cargarPersona(persona2);
		
		
		personal.cargarIncompatibles(persona, persona2);
		HashSet<Persona> incompatibles = new HashSet<>();
		incompatibles =  personal.getIncompatibles(persona);
		Persona personaIncompatible = incompatibles.iterator().next();
		
		assertEquals(persona2,personaIncompatible);
		
		incompatibles =  personal.getIncompatibles(persona2);
		personaIncompatible = incompatibles.iterator().next();
		
		assertEquals(persona,personaIncompatible);
	}

}
