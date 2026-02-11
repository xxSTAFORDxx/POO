package Hospital_Infernal_2;

import Hospital_Infernal.Gravedad;

public class Persona {
	// atributos de la persona
	public String nombre;
	public int edad;

	public void diElNombre() {

		System.out.println(this.nombre);
	}

	public Persona(String nombre) {
		this.nombre = nombre;
	}
}