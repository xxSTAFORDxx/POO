package Hospital_Infernal_2;

import java.util.ArrayList;

import Hospital_Infernal_2.Categoria;
import Hospital_Infernal_2.Gravedad;
import Hospital_Infernal_2.Paciente;

public class Medico extends Persona {

	int añosTrabajados;
	double sueldo;
	Categoria categoria;
	ArrayList<Paciente> pacientsAssignats;

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
		if (pac.edad < 15 || pac.gravedad == Gravedad.CRITICA) {
			precioConsulta = 0;
		}
		if (pac.dinero >= precioConsulta) {
			pac.dinero -= precioConsulta;
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