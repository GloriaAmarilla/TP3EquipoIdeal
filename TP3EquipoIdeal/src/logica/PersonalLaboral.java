package logica;

import java.util.HashMap;
import java.util.HashSet;

public class PersonalLaboral {
	private HashSet <Persona> _personas;
	private HashMap <Persona, HashSet<Persona>> _incompatibles;
	
	public PersonalLaboral () {
		_personas = new HashSet <Persona> ();
		_incompatibles = new HashMap <Persona, HashSet<Persona>>();
	}
	
	public void cargarPersona(Persona persona) {
		_personas.add(persona);
		
		HashSet <Persona> listaVacia = new HashSet<Persona>();
		_incompatibles.put(persona, listaVacia);
	}
	
	public void cargarIncompatibles(Persona persona, Persona pers_incompatible) {
		HashSet<Persona> pers_Incompatibles_de_sugeto_1 = _incompatibles.get(persona);
		HashSet<Persona> pers_Incompatibles_de_sugeto_2 = _incompatibles.get(pers_incompatible);

		pers_Incompatibles_de_sugeto_1.add(pers_incompatible);
		pers_Incompatibles_de_sugeto_2.add(persona);
	}
	
	public HashSet<Persona> getPersonas(){
		return _personas;
	}
	
	public HashSet<Persona> getIncompatibles(Persona persona) {
		return _incompatibles.get(persona);
	}
		
}
