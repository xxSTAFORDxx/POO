package Hospital_Infernal_3;

import java.util.ArrayList;

import Hospital_Infernal_3.Gravedad;
import Hospital_Infernal_3.Planta;

public class Paciente extends Persona {
	
	private double dinero;
	private int edad;
	private ArrayList<Sintoma> sintomas;
	private Planta planta;
	private Gravedad gravedad;

	public Paciente(String nombre) {
		super(nombre);
	}

	public Paciente(String nombre, int edad) {
		super(nombre, edad);
		this.sintomas = new ArrayList<Sintoma>();
		this.gravedad = Gravedad.LEVE;
	}

	public void añadirSintoma(Sintoma s) {
		this.sintomas.add(s);
		if (s.gravedad.getNivel() > this.gravedad.getNivel()) {
			this.gravedad = s.gravedad;
			System.out.println("Atención: La gravedad de " + this.getNombre() + " ha subido a " + this.gravedad);
		}
	}

	public Paciente_Hospitalizado hospitalizar(String tratamiento) {

		if (!(this instanceof Paciente_Hospitalizado)) {
			Paciente_Hospitalizado nuevoPaciente = new Paciente_Hospitalizado(this, tratamiento);
			System.out.println(this.getNombre() + " ha sido hospitalizado.");
			return nuevoPaciente;
		} else {
			System.out.println("Aquest pacient ja està hospitalitzat");
			return (Paciente_Hospitalizado) this;
		}
	}
	
	public Paciente(String nombre, double sueldo, int edad, Gravedad gravedad) {
		super(nombre, edad);
		this.gravedad = gravedad;
		
		if (this.getEdad() <= 1) {
			this.planta=Planta.NEONATAL;
		} else if (this.getEdad() <= 18) {
			this.planta=Planta.PEDIATRIA;
		} else if (this.getEdad() <= 74) {
			this.planta=Planta.GENERAL;
		} else {
			this.planta= Planta.GERIATRIA;
		}
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Gravedad getGravedad() {
		return gravedad;
	}

	public void setGravedad(Gravedad gravedad) {
		this.gravedad = gravedad;
	}

	public ArrayList<Sintoma> getSintomas() {
		return sintomas;
	}

	public Planta getPlanta() {
		return planta;
	}

}