package Hospital_Infernal_5;

public class Persona {
	
	private String nombre;

	public void diElNombre() {

		System.out.println(this.nombre);
	}

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
}