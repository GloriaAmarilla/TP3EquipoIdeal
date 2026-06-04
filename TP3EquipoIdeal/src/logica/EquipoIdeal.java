package logica;

import java.util.ArrayList;
import java.util.HashSet;

public class EquipoIdeal implements Runnable {

	private int _cantLideres;
	private int _cantArquitectos;
	private int _cantProgramadores;
	private int _cantTesters;
	private int _mejorCalificacion;

	private HashSet<Persona> _integrantes;
	private HashSet<Persona> _integrantes_a_Evaluar;
	private PersonalLaboral _personal;
	private ResultadoListener _listener;

	private int _cantidadDeEvaluaciones;
	private long _tiempoTotal;

	public interface ResultadoListener {
		void onResultado(HashSet<Persona> equipo, int evaluaciones, long tiempoMs);
	}

	public EquipoIdeal(int cantLideres, int cantArquitectos, int cantProgramadores, int cantTesters,
			PersonalLaboral personal, ResultadoListener listener) {

		if (personal == null)
			throw new IllegalArgumentException("El personal no puede ser nulo");
		if (listener == null)
			throw new IllegalArgumentException("El listener no puede ser nulo");

		_cantLideres = cantLideres;
		_cantArquitectos = cantArquitectos;
		_cantProgramadores = cantProgramadores;
		_cantTesters = cantTesters;
		_personal = personal;
		_listener = listener;

		_integrantes = new HashSet<>();
		_integrantes_a_Evaluar = new HashSet<>();
	}

	@Override
	public void run() {
		_mejorCalificacion = -1;
		_cantidadDeEvaluaciones = 0;
		_integrantes.clear();
		_integrantes_a_Evaluar.clear();

		ArrayList<Persona> disponibles = new ArrayList<>(_personal.getPersonas());

		long inicio = System.currentTimeMillis();
		seleccionarLider(disponibles, 0, 0);
		_tiempoTotal = System.currentTimeMillis() - inicio;

		_listener.onResultado(new HashSet<>(_integrantes), _cantidadDeEvaluaciones, _tiempoTotal);
	}

	private boolean sonIncompatibles(Persona persona) {
		HashSet<Persona> incompatibles = _personal.getIncompatibles(persona);
		for (Persona per : _integrantes_a_Evaluar) {
			if (incompatibles.contains(per))
				return true;
		}
		return false;
	}

	private void seleccionarLider(ArrayList<Persona> disponibles, int indice, int cantDeLideres) {
		if (cantDeLideres == _cantLideres) {
			seleccionarArquitecto(disponibles, 0, 0);
			return;
		}
		if (indice >= disponibles.size())
			return;

		Persona persona = disponibles.get(indice);

		if (persona.getRol().equalsIgnoreCase("LIDER") && !sonIncompatibles(persona)) {
			_integrantes_a_Evaluar.add(persona);
			seleccionarLider(disponibles, indice + 1, cantDeLideres + 1);
			_integrantes_a_Evaluar.remove(persona);
		}
		seleccionarLider(disponibles, indice + 1, cantDeLideres);
	}

	private void seleccionarArquitecto(ArrayList<Persona> disponibles, int indice, int cantDeArquitectos) {
		if (cantDeArquitectos == _cantArquitectos) {
			seleccionarProgramador(disponibles, 0, 0);
			return;
		}
		if (indice >= disponibles.size())
			return;

		Persona persona = disponibles.get(indice);

		if (persona.getRol().equalsIgnoreCase("ARQUITECTO") && !sonIncompatibles(persona)) {
			_integrantes_a_Evaluar.add(persona);
			seleccionarArquitecto(disponibles, indice + 1, cantDeArquitectos + 1);
			_integrantes_a_Evaluar.remove(persona);
		}
		seleccionarArquitecto(disponibles, indice + 1, cantDeArquitectos);
	}

	private void seleccionarProgramador(ArrayList<Persona> disponibles, int indice, int cantDeProgramador) {
		if (cantDeProgramador == _cantProgramadores) {
			seleccionarTester(disponibles, 0, 0);
			return;
		}
		if (indice >= disponibles.size())
			return;

		Persona persona = disponibles.get(indice);

		if (persona.getRol().equalsIgnoreCase("PROGRAMADOR") && !sonIncompatibles(persona)) {
			_integrantes_a_Evaluar.add(persona);
			seleccionarProgramador(disponibles, indice + 1, cantDeProgramador + 1);
			_integrantes_a_Evaluar.remove(persona);
		}
		seleccionarProgramador(disponibles, indice + 1, cantDeProgramador);
	}

	private void seleccionarTester(ArrayList<Persona> disponibles, int indice, int cantDeTester) {
		if (cantDeTester == _cantTesters) {
			evaluarEquipoActual();
			return;
		}
		if (indice >= disponibles.size())
			return;

		Persona persona = disponibles.get(indice);

		if (persona.getRol().equalsIgnoreCase("TESTER") && !sonIncompatibles(persona)) {
			_integrantes_a_Evaluar.add(persona);
			seleccionarTester(disponibles, indice + 1, cantDeTester + 1);
			_integrantes_a_Evaluar.remove(persona);
		}
		seleccionarTester(disponibles, indice + 1, cantDeTester);
	}

	private void evaluarEquipoActual() {
		_cantidadDeEvaluaciones++;
		int calificacionTotal = 0;
		for (Persona pers : _integrantes_a_Evaluar) {
			calificacionTotal += pers.getCalificacion();
		}
		if (_mejorCalificacion < calificacionTotal) {
			_mejorCalificacion = calificacionTotal;
			_integrantes = new HashSet<>(_integrantes_a_Evaluar);
		}
	}

	public int getMejorCalificacion() {
		return _mejorCalificacion;
	}
}