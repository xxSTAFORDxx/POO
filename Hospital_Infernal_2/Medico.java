package Hospital_Infernal_2;

import java.util.ArrayList;

import Hospital_Infernal_2.Categoria;
import Hospital_Infernal_2.Gravedad;
import Hospital_Infernal_2.Paciente;

public class Medico extends Persona {

	int añosTrabajados;
	double sueldo;
	String departamento;
	Categoria categoria;
	ArrayList<Paciente> pacientsAssignats;

	public Medico() {
		super("Sin definir");
		this.añosTrabajados = 0;
		this.sueldo = 1000.0;
		this.departamento = "Sin departamento";
		this.categoria = Categoria.INTERNO;
		this.pacientsAssignats = new ArrayList<>();
	}
	
	public Medico(String nombre) {
		super(nombre);
		this.añosTrabajados = 0;
		this.sueldo = 1000.0;
		this.departamento = "Sin departamento";
		this.categoria = Categoria.INTERNO;
		this.pacientsAssignats = new ArrayList<>();
	}

	public void augmentarAñosTrabajados() {
		this.añosTrabajados++;
		this.sueldo *= 1.02;
		if (this.añosTrabajados % 6 == 0) {
			this.sueldo *= 1.05;
		}
	}

	public Medico(String nombre, Categoria cat) {
		this(nombre);
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
	
	public void diElNombre() {
		System.out.println("Médico: " + this.nombre + " | Dept: " + this.departamento);
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
		if (pac.dinero >= precioConsulta) {
			pac.dinero -= precioConsulta;
			pac.dinero += precioConsulta;
			this.pacientsAssignats.add(pac);
			System.out.println("Consulta realizada a " + pac.nombre + ". Precio: " + precioConsulta + "€");
			return true;
		} else {
			System.out.println("El paciente " + pac.nombre + " no tiene suficiente dinero para la consulta.");
			return false;

		}
	}
}