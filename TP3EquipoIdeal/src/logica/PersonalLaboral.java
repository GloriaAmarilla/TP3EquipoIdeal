package logica;

import java.util.HashMap;
import java.util.HashSet;

public class PersonalLaboral {
	private HashSet <Persona> _personas;
	private HashMap <Persona, HashSet<Persona>> _incompatibles;
	
	public PersonalLaboral () {
		_personas = new HashSet <Persona> ();
		_incompatibles = new HashMap <>();
	}
	
	public void cargarPersona(Persona persona) {
		_personas.add(persona);
	}
	
	public void cargarIncompatibles(Persona persona, Persona pers_incompatible) {
		HashSet<Persona> personasIncompatibles = new HashSet<>();
		personasIncompatibles = _incompatibles.get(persona);
		personasIncompatibles.add(pers_incompatible);
	}
	
	public HashSet<Persona> getPersonas(){
		return _personas;
	}
	
	@SuppressWarnings("unchecked")
	public HashSet<Persona> get_incompatibles(Persona persona) {
		return (HashSet<Persona>) _incompatibles.get(persona).clone();
	}
		
}
