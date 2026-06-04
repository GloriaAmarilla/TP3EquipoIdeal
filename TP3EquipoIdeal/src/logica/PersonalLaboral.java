package logica;

import java.util.HashMap;
import java.util.HashSet;

public class PersonalLaboral {
	private HashSet<Persona> _personas;
	private HashMap<Persona, HashSet<Persona>> _incompatibles;

	public PersonalLaboral() {
		_personas = new HashSet<Persona>();
		_incompatibles = new HashMap<Persona, HashSet<Persona>>();
	}

	public void cargarPersona(Persona persona) {
		if (persona == null)
			throw new IllegalArgumentException("La persona no puede ser nula");
		_personas.add(persona);
		HashSet<Persona> listaVacia = new HashSet<Persona>();
		_incompatibles.put(persona, listaVacia);
	}

	public void cargarIncompatibles(Persona persona, Persona pers_incompatible) {
		if (persona.equals(pers_incompatible))
			throw new IllegalArgumentException("Una persona no puede ser incompatible consigo misma");
		if (_incompatibles.get(persona).contains(pers_incompatible))
			throw new IllegalArgumentException("Esta incompatibilidad ya fue existe");
		HashSet<Persona> pers_Incompatibles_de_sujeto_1 = _incompatibles.get(persona);
		HashSet<Persona> pers_Incompatibles_de_sujeto_2 = _incompatibles.get(pers_incompatible);

		pers_Incompatibles_de_sujeto_1.add(pers_incompatible);
		pers_Incompatibles_de_sujeto_2.add(persona);
	}

	public boolean estaPersonaCargada(Persona persona) {
		return _personas.contains(persona);
	}

	public HashSet<Persona> getPersonas() {
		return _personas;
	}

	public HashSet<Persona> getIncompatibles(Persona persona) {
		if (!_personas.contains(persona))
			throw new IllegalArgumentException("La persona no está cargada");
		return _incompatibles.get(persona);
	}

}
