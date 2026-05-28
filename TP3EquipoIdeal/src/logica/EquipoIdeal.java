package logica;
import java.util.HashSet;

public class EquipoIdeal {
	private int _cantIntegrantes;
	private int _cantLideres;
	private int _cantAquitectos;
	private int _cantProgramadores; 
	private int _cantTesters;
	private HashSet <Persona> _integrantes;
	private PersonalLaboral _personalDisponible;
	
	
	public EquipoIdeal (int cantIntegrantes, int cantLideres, int cantArquitectos, int cantProgramadores, int cantTesteres) {
		_cantIntegrantes = cantIntegrantes;
		_cantLideres = cantLideres;
		_cantAquitectos = cantArquitectos;
		_cantProgramadores = cantProgramadores;
		_cantTesters = cantTesteres;
	}

	private HashSet<Persona> formar(HashSet<Persona> personasDisponibles) {
		//acá se debe formar el equipo mejor calificado con personas que no esten en la lista de incompatibles
		return null;
	}

	private void setPersonalDisponible(PersonalLaboral personalDisponible) {
		_personalDisponible = personalDisponible;
	}
}
