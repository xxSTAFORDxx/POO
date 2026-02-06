package Hospital_Infernal;

public class Medico {

	String nombre;
	int añosTrabajados;
	double sueldo;
	String departamento;
	Categoria categoria;

	public Medico() {
		this.nombre = "Sin definir";
		this.añosTrabajados = 0;
		this.sueldo = 1000.0;
		this.departamento = "Sin departamento";
	}

	public Medico(String nom) {
		this.nombre = nom;
		this.añosTrabajados = 0;
		this.sueldo = 1000.0;
		this.departamento = "Sin departamento";
	}

	public Medico(String nombre, int añosTrabajados) {
		this(nombre);
		for (int i = 0; i < añosTrabajados; i++) {
			this.augmentarAñosTrabajados();
		}
	}

	public Medico(String nombre, String departamento, double sueldoInicial, int añosTrabajados) {
		this.nombre = nombre;
		this.departamento = departamento;
		this.sueldo = sueldoInicial;
		this.añosTrabajados = 0;
		for (int i = 0; i < añosTrabajados; i++) {
			this.augmentarAñosTrabajados();
		}

	}
    public Medico(String nombre, Categoria cat) {
    
        this.nombre = nombre;
        this.añosTrabajados = 0;
        this.sueldo = 1000.0;
        this.departamento="Sin departament";
	  this.categoria = cat;
    }

	
	public void augmentarAñosTrabajados() {
		this.añosTrabajados++;
		this.sueldo *= 1.02;
		if (this.añosTrabajados % 6 == 0) {
			this.sueldo *= 1.05;
		}
	}

	public void diElNombre() {

		System.out.println(this.nombre);
	}
}