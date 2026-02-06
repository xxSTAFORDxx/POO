package Hospital_Infernal;

public class Paciente {

	String nombre;
	double sueldo;
	int edad;
	Gravedad gravedad;
	Planta planta;

	public Paciente(String nombre, double sueldo, int edad, Gravedad gravedad) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.gravedad = gravedad;
		if (edad < 0) {
			edad = 0;
		} else if (edad >= 150) {
			edad = 150;
		}
		this.edad = edad;
		if (this.edad <= 1) {
			this.planta = "NEONATAL";
		} else if (this.edad <= 18) {
			this.planta = "PEDIATRIA";
		} else if (this.edad <= 74) {
			this.planta = "GENERAL";
		} else {
			this.planta = "GERIATRIA";
		}
	}

	public void diElNombre() {

		System.out.println(this.nombre);
	}
}