	package Hospital_Infernal_2;

public class Persona {
	// atributos de la persona
	String nombre;
	int edad;

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
}