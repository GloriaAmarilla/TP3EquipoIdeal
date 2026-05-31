package logica;

public class Persona {
	private String _nombre;
	private String _apellido;
	private int _calificacion;
	private String _rol;
	
	
	public Persona(String nombre, String apellido, int calificacion, String rol) {
		_nombre = nombre;
		_apellido = apellido;
		
		if (!calificacionValida(calificacion))
			throw new IllegalArgumentException ("Calificacion debe estar entre 1 y 5");
		_calificacion = calificacion;
		
		if (!rolValido(rol))
			throw new IllegalArgumentException ("Rol no reconocido");
		_rol = rol;
	}
	
	private boolean rolValido(String rol) {
		String rolMayusculas = rol.toUpperCase();
		
		if("LIDER".equals(rolMayusculas) || "ARQUITECTO".equals(rolMayusculas)
			|| "PROGRAMADOR".equals(rolMayusculas) || "TESTER".equals(rolMayusculas)) {
			return true;
		}
		
		return false;
	}

	private boolean calificacionValida(int calificacion) {
		return calificacion<=5 && calificacion>=1;
	}

	public String toString() {
		return _nombre + " " + _apellido + " [" + _rol + " - " + _calificacion + "]";
	}
	
	public String getNombre() {
		return _nombre;
	}
	
	public String getApellido() {
		return _apellido;
	}
	
	public int getCalificacion() {
		return _calificacion;
	}
	
	public String getRol() {
		return _rol;
	}
	
}
