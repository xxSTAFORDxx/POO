package Hospital_Infernal_4;

public abstract class Tratamiento {

	private String nombre;
	private int cantidad;

	public Tratamiento(String nombre) {
		this.nombre = nombre;
		this.cantidad = 1;

	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int numTratamientos() {
		return cantidad++;
	}

	public abstract void administrar(Paciente_Hospitalizado pac);
}
