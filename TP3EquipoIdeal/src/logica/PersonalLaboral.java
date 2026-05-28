package logica;

import java.util.HashSet;

public class PersonalLaboral {
	private HashSet <Persona> _personas;
	private HashSet <Persona[]> _incompatibles;
	
	public PersonalLaboral () {
		_personas = new HashSet <Persona> ();
		_incompatibles = new HashSet <Persona[]>();
	}
	
	public void cargarPersona(Persona persona) {
		_personas.add(persona);
	}
	
	public HashSet<Persona> getPersonas(){
		return _personas;
	}
	
	public void cargarIncompatibles(Persona una, Persona otra) {
		Persona [] parIncompatible = new Persona [2];
		parIncompatible[0] = una;
		parIncompatible[1] = otra;
		_incompatibles.add(parIncompatible);
	}

	public HashSet<Persona[]> get_incompatibles() {
		return _incompatibles;
	}
		
}
