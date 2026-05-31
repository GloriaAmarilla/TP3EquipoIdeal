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
    public void testConstructorListenerNulo() {
        new EquipoIdeal(1, 1, 1, 1, personal, null);
    }
}
