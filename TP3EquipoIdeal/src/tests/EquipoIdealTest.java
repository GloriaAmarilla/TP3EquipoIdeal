package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logica.EquipoIdeal;
import logica.Persona;
import logica.PersonalLaboral;

public class EquipoIdealTest {

	private PersonalLaboral personal;

	@Before
	public void setUp() {
		personal = new PersonalLaboral();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void listenerNuloTest() {
		new EquipoIdeal(1, 1, 1, 1, personal, null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void personalNuloTest() {
		PersonalLaboral personalNulo = null;
		EquipoIdeal.ResultadoListener listener = (equipo, evaluaciones, tiempo) -> {
		};
		@SuppressWarnings("unused")
		EquipoIdeal equipo = new EquipoIdeal(1,2,3,4,personalNulo,listener);
	}
	
	@Test
	public void respetaIncompatibilidadesTest() {
		Persona lider1 = new Persona("Juan", "lider", 5, "LIDER");
		Persona tester1 = new Persona("Juan", "test1", 5, "TESTER");
		Persona tester2 = new Persona("Juan", "test2", 3, "TESTER");

		personal.cargarPersona(lider1);
		personal.cargarPersona(tester1);
		personal.cargarPersona(tester2);
		personal.cargarIncompatibles(lider1, tester1);

		EquipoIdeal.ResultadoListener listener = (equipo, evaluaciones, tiempo) -> {
		};
		EquipoIdeal equipo = new EquipoIdeal(1, 0, 0, 1, personal, listener);
		equipo.run();
		assertEquals(8, equipo.getMejorCalificacion());
	}

	@Test
	public void calificacionTotalCorrectaTest() {
		Persona lider = new Persona("Juan", "lider", 5, "LIDER");
		Persona arquitecto = new Persona("Juan", "arquitecto", 4, "ARQUITECTO");
		Persona tester = new Persona("Juan", "tester", 3, "TESTER");

		personal.cargarPersona(lider);
		personal.cargarPersona(arquitecto);
		personal.cargarPersona(tester);

		EquipoIdeal.ResultadoListener listener = (equipo, evaluaciones, tiempo) -> {
		};
		EquipoIdeal equipo = new EquipoIdeal(1, 1, 0, 1, personal, listener);
		equipo.run();

		assertEquals(12, equipo.getMejorCalificacion());
	}
}
