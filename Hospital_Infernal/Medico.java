package Hospital_Infernal;

import java.util.ArrayList;

public class Medico {

	// Atributos
	String nombre;
	int añosTrabajados;
	double sueldo;
	String departamento;
	Categoria categoria;
	ArrayList<Paciente> pacientsAssignats;

	// Constructor 1: Vacío
	public Medico() {
		this.nombre = "Sin definir";
		this.añosTrabajados = 0;
		this.sueldo = 1000.0;
		this.departamento = "Sin departamento";
		this.categoria = Categoria.INTERNO;
		this.pacientsAssignats = new ArrayList<>();
	}

	public Medico(String nombre) {
		this(); // Llama al de arriba para heredar valores por defecto
		this.nombre = nombre;
	}

	public Medico(String nombre, Categoria cat) {
		this(nombre); // Llama al de arriba
		this.categoria = cat;
	}

	public Medico(String nombre, int añosTrabajados) {
		this(nombre);
		for (int i = 0; i < añosTrabajados; i++) {
			this.augmentarAñosTrabajados();
		}
	}

	public Medico(String nombre, String departamento, double sueldoInicial, int añosTrabajados) {
		this(nombre);
		this.departamento = departamento;
		this.sueldo = sueldoInicial;
		for (int i = 0; i < añosTrabajados; i++) {
			this.augmentarAñosTrabajados();
		}
	}

	// Métodos

	public void diElNombre() {
		System.out.println("Médico: " + this.nombre + " | Dept: " + this.departamento);
	}

	public void augmentarAñosTrabajados() {
		this.añosTrabajados++;
		this.sueldo *= 1.02; // +2% IPC
		if (this.añosTrabajados % 6 == 0) {
			this.sueldo *= 1.05; // +5% Sexenio
		}
	}

	public void afegirPacient(Paciente pac) {
		this.pacientsAssignats.add(pac);
		System.out.println("Paciente " + pac.nombre + " asignado al Dr. " + this.nombre);
	}

	public boolean consulta(Paciente pac) {
		int multiplicador = 0;

		switch (this.categoria) {
		case INTERNO:
			multiplicador = 1;
			break;
		case RESIDENTE:
			multiplicador = 2;
			break;
		case ESPECIALISTA:
			multiplicador = 3;
			break;
		}
		double precioConsulta = 10.0 * multiplicador;
		if (pac.edad < 15 || pac.gravedad == Gravedad.CRITICA) {
			precioConsulta = 0;
		}
		if (pac.sueldo >= precioConsulta) {
			pac.sueldo -= precioConsulta;
			this.sueldo += precioConsulta;
			this.pacientsAssignats.add(pac);
			System.out.println("Consulta realizada a " + pac.nombre + ". Precio: " + precioConsulta + "€");
			return true;
		} else {
			System.out.println("El paciente " + pac.nombre + " no tiene suficiente dinero para la consulta.");
			return false;
		}
	}
}