package Hospital_Infernal_3;

public class Persona {
	
	private String nombre;
	private int edad;

	public void diElNombre() {

		System.out.println(this.nombre);
	}

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
}