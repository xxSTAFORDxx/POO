package Hospital_Infernal_3;

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