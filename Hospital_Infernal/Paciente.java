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
		if (edad <= 0) {
			edad = 0;
		} else if (edad >= 150) {
			edad = 150;
		}
		this.edad = edad;
		if (this.edad <= 1) {
			this.planta=Planta.NEONATAL;
		} else if (this.edad <= 18) {
			this.planta=Planta.PEDIATRIA;
		} else if (this.edad <= 74) {
			this.planta=Planta.GENERAL;
		} else {
			this.planta= Planta.GERIATRIA;
		}
	}

	public Paciente(String nombre, int edad) {
	    this(nombre, 0.0, edad, Gravedad.LEVE);
	    
	    
	}
	
	public Paciente(String nombre, double sueldo, int edad) {
	    this(nombre, sueldo, edad, Gravedad.LEVE);
	    
	    
	}
	
	public void diElNombre() {

		System.out.println(this.nombre);
	}
}