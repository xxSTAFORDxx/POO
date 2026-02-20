package Hospital_Infernal_3;

import java.util.ArrayList;

public class Medico extends Persona {

	private int añosTrabajados;
	private double sueldo;
	private Categoria categoria;
	private String departamento;
	private ArrayList<Paciente> pacientsAssignats;

	public Medico(String nombre) {
		super(nombre);
		this.añosTrabajados = 0;
		this.sueldo = 1000.0;
		this.categoria = Categoria.INTERNO;
		this.pacientsAssignats = new ArrayList<>();
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
		if (pac.getEdad() < 15 || pac.getGravedad() == Gravedad.CRITICA) {
			precioConsulta = 0;
		}
		if (pac.getDinero() >= precioConsulta) {
			pac.setDinero(pac.getDinero() - precioConsulta);
			this.sueldo += precioConsulta;
			this.pacientsAssignats.add(pac);
			System.out.println("Consulta realizada a " + pac.getNombre() + ". Precio: " + precioConsulta + "€");
			return true;
		} else {
			System.out.println("El paciente " + pac.getNombre() + " no tiene suficiente dinero para la consulta.");
			return false;

		}
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

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}