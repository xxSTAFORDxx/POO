package Hospital_Infernal_3;

import java.util.ArrayList;

public class Medico extends Persona {

	private int añosTrabajados;
	private double sueldo;
	private Categoria categoria;
	private String departamento;
	private ArrayList<Paciente> pacientsAssignats;

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
		actualizarSueldo();
	}

	private void actualizarSueldo() {
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
		super(nombre);
		this.departamento = departamento;
		this.sueldo = sueldoInicial;
		for (int i = 0; i < añosTrabajados; i++) {
			this.augmentarAñosTrabajados();
		}
	}

	public void diElNombre() {
		System.out.println("Médico: " + this.getNombre() + " | Dept: " + this.departamento);
	}

	public void afegirPacient(Paciente pac) {
		this.pacientsAssignats.add(pac);
		System.out.println("Paciente " + pac.getNombre() + " asignado al Dr. " + this.getNombre());
	}

	public boolean consulta(Paciente pac) {
		double precioConsulta = calcularPrecioConsulta(pac.getEdad(), pac.getGravedad(), this.categoria);
		if (pac.getDinero() >= precioConsulta) {
			pac.setDinero(pac.getDinero() - precioConsulta);
			this.pacientsAssignats.add(pac);
			System.out.println("Consulta realizada a " + pac.getNombre() + ". Precio: " + precioConsulta + "€");
			return true;
		} else {
			System.out.println("El paciente " + pac.getNombre() + " no tiene suficiente dinero para la consulta.");
			return false;

		}
	}

	static double calcularPrecioConsulta(int edad, Gravedad gravedad, Categoria categoria) {
		int multiplicador = 0;

		double precioConsulta = 10.0 * multiplicador;
		if (edad < 15 || gravedad == Gravedad.CRITICA) {
			precioConsulta = 0;
		}

		switch (categoria) {
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
		return precioConsulta;
	}

	public int getAñosTrabajados() {
		return añosTrabajados;
	}

	public ArrayList<Paciente> getPacientsAssignats() {
		return pacientsAssignats;
	}

	public double getSueldo() {
		return sueldo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String nuevoDepartamento) {
		System.out.println("Medico " + getNombre() + ": Canvio de departamento de " + this.departamento + " a "
				+ nuevoDepartamento);
		this.departamento = nuevoDepartamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria nuevaCategoria) {
		if (nuevaCategoria == Categoria.INTERNO && (getCategoria() != Categoria.INTERNO || getAñosTrabajados() > 2)) {
			System.out.println("❌ ERROR: El metge " + getNombre()
					+ " no puede bajar de categoria o ya tiene mucha experiència per ser Interno.");
		} else {
			System.out.println("la categoria de " + getNombre() + " ahora es " + nuevaCategoria);
			this.categoria = nuevaCategoria;
		}
	}

	public String toString() {
		return super.toString() + "Medico [añosTrabajados=" + añosTrabajados + ", sueldo=" + sueldo + ", categoria="
				+ categoria + ", departamento=" + departamento + ", pacientsAssignats=" + pacientsAssignats + "]";
	}
}