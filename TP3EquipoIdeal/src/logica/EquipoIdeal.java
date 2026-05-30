package logica;
import java.util.ArrayList;
import java.util.HashSet;

public class EquipoIdeal {
	
	private int _cantIntegrantes;
	private int _cantLideres;
	private int _cantArquitectos;
	private int _cantProgramadores; 
	private int _cantTesters;
	private int _mejorCalificacion;
	
	private HashSet <Persona> _integrantes;
	private HashSet <Persona> _integrantes_a_Evaluar;
	private HashSet <Persona> _personalDisponible;
	private PersonalLaboral _personal;
	
	
	public EquipoIdeal (int cantIntegrantes, int cantLideres, int cantArquitectos, 
			int cantProgramadores, int cantTesteres) {
		
		_integrantes = new HashSet <Persona>();
		_integrantes_a_Evaluar = new HashSet <Persona>();
		
		_cantIntegrantes = cantIntegrantes;
		_cantLideres = cantLideres;
		_cantArquitectos = cantArquitectos;
		_cantProgramadores = cantProgramadores;
		_cantTesters = cantTesteres;
		
		_personal = new PersonalLaboral();
		_personalDisponible = new HashSet <Persona> ();
		_personalDisponible = _personal.getPersonas();
		
		
	}

	public HashSet<Persona> formar() {
		_mejorCalificacion = -1;
		_integrantes.clear();
		_integrantes_a_Evaluar.clear();
		
		ArrayList<Persona> disponibles = new ArrayList<>(_personalDisponible);


		seleccionarLider(disponibles, 0, 0);
		
		return _integrantes;
	}
	
	private boolean sonIncompatibles(Persona persona) {
		
		if (_integrantes_a_Evaluar != (null)) {
			
			HashSet<Persona> personalIncompatibles = new HashSet<Persona>();
			personalIncompatibles = _personal.getIncompatibles(persona);
			
			for (Persona per: _integrantes_a_Evaluar) {
				if(personalIncompatibles.contains(per)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private void seleccionarLider(ArrayList<Persona> disponibles, int indice, int cantDeLideres) {
		
		if (cantDeLideres == _cantLideres) {
			seleccionarArquitecto(disponibles, 0, 0);
			return;
		}
		
		if (indice >= disponibles.size()) {
			return;
		}
		
		Persona persona = disponibles.get(indice);
		String rol = persona.getRol().toUpperCase();
		
		if (rol.equals("LIDER") && !sonIncompatibles(persona)) {
			_integrantes_a_Evaluar.add(persona);
			seleccionarLider(disponibles, indice + 1, cantDeLideres + 1);
			_integrantes_a_Evaluar.remove(persona);//Backtracking
		}
		seleccionarLider(disponibles, indice + 1, cantDeLideres);
	}
	
	private void seleccionarArquitecto(ArrayList<Persona> disponibles, int indice, int cantDeArquitectos) {
		if (cantDeArquitectos == _cantArquitectos) {
			seleccionarProgramador(disponibles, 0, 0);
			return;
		}
		if (indice >= disponibles.size()) {
			return;
		}
		
		Persona persona = disponibles.get(indice);
		String rol = persona.getRol().toUpperCase();
		
		if (rol.equals("ARQUITECTO") && !sonIncompatibles(persona)) {
			_integrantes_a_Evaluar.add(persona);
			seleccionarArquitecto(disponibles, indice + 1, cantDeArquitectos + 1);
			_integrantes_a_Evaluar.remove(persona); //Backtracking
		}
		
		seleccionarArquitecto(disponibles, indice + 1, cantDeArquitectos);
	}
	
	private void seleccionarProgramador(ArrayList<Persona> disponibles, int indice, int cantDeProgramador) {
		if (cantDeProgramador == _cantProgramadores) {
			seleccionarTester(disponibles, 0, 0);
			return;
		}
		if (indice >= disponibles.size()) {
			return;
		}
		
		Persona persona = disponibles.get(indice);
		String rol = persona.getRol().toUpperCase();
		
		if (rol.equals("PROGRAMADOR") && !sonIncompatibles(persona)) {
			_integrantes_a_Evaluar.add(persona);
			seleccionarProgramador(disponibles, indice + 1, cantDeProgramador + 1);
			_integrantes_a_Evaluar.remove(persona); //Backtracking
		}
		
		seleccionarProgramador(disponibles, indice + 1, cantDeProgramador);
	}
	
	private void seleccionarTester(ArrayList<Persona> disponibles, int indice, int cantDeTester) {
		
		if (cantDeTester == _cantTesters) {
			evaluarEquipoActual();
			return;
		}
		if (indice >= disponibles.size()) {
			return;
		}
		
		Persona persona = disponibles.get(indice);
		String rol = persona.getRol().toUpperCase();
		
		if (rol.equals("TESTER") && !sonIncompatibles(persona)) {
			_integrantes_a_Evaluar.add(persona);
			seleccionarTester(disponibles, indice + 1, cantDeTester + 1);
			_integrantes_a_Evaluar.remove(persona); //Backtracking
		}
		
		seleccionarTester(disponibles, indice + 1, cantDeTester);
	}
	

	private void evaluarEquipoActual() {
		int calificacionTotal = 0;
		for(Persona pers : _integrantes_a_Evaluar) {
			calificacionTotal += pers.getCalificacion();
		}
		if(_mejorCalificacion < calificacionTotal) {
			_mejorCalificacion = calificacionTotal;
			_integrantes = new HashSet<> (_integrantes_a_Evaluar);
		}
		
	}
}
