package Hospital_Infernal_3;

import java.util.ArrayList;

public class Paciente extends Persona {

	private double dinero;
	private int edad;
	private ArrayList<Sintoma> sintomas;
	private Planta planta;
	private Gravedad gravedad;
	static String estatic;

	public Paciente(String nombre) {
		super(nombre);
	}

	public Paciente(String nombre, double dinero, int edad, Gravedad gravedad) {
		super(nombre);
		this.dinero = dinero;
		this.edad = edad;
		this.gravedad = gravedad;
		this.sintomas = new ArrayList<Sintoma>();
		if (this.getEdad() <= 1) {
			this.planta = Planta.NEONATAL;
		} else if (this.getEdad() <= 18) {
			this.planta = Planta.PEDIATRIA;
		} else if (this.getEdad() <= 74) {
			this.planta = Planta.GENERAL;
		} else {
			this.planta = Planta.GERIATRIA;
		}
	}

	public Paciente() {
		super("Sin definir");
		this.dinero = 0;
		this.edad = 0;
		this.gravedad = Gravedad.LEVE;
	}

	public Paciente(String nombre, int edad) {
		super(nombre);
		this.edad = edad;
		this.sintomas = new ArrayList<Sintoma>();
		this.gravedad = Gravedad.LEVE;
	}

	public Paciente(String nombre, double dinero, int edad) {
		this(nombre, dinero, edad, Gravedad.LEVE);
	}

	public void diElNombre() {

		System.out.println(this.getNombre());
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
			System.out.println("Este paciente ya esta hospitalizado.");
			return (Paciente_Hospitalizado) this;
		}
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double nuevoDinero) {
		System.out.println("El saldo de " + getNombre() + " ha pasado de " + this.dinero + "€ a " + nuevoDinero + "€");
		this.dinero = nuevoDinero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int nuevaEdad) {
		if (edad < 0) {
			edad = 0;
		} else if (edad > 150) {
			edad = 150;
		}
		System.out.println(getNombre() + " ahora tiene " + nuevaEdad + " años.");
		this.edad = nuevaEdad;
		if (this.edad <= 1) {
			this.planta = Planta.NEONATAL;
		} else if (this.edad <= 18) {
			this.planta = Planta.PEDIATRIA;
		} else if (this.edad <= 74) {
			this.planta = Planta.GENERAL;
		} else {
			this.planta = Planta.GERIATRIA;
		}
	}

	public Gravedad getGravedad() {
		return gravedad;
	}

	public void setGravedad(Gravedad nuevaGravedad) {
		System.out.println("El estado de " + getNombre() + " ha canviado a " + nuevaGravedad);
		this.gravedad = nuevaGravedad;
	}

	public ArrayList<Sintoma> getSintomas() {
		return sintomas;
	}

	public Planta getPlanta() {
		return planta;
	}

	public String toString() {
		return super.toString()
				+ "Paciente [dinero=" + dinero + ", edad=" + edad + ", sintomas=" + sintomas
				+ ", planta=" + planta + ", gravedad=" + gravedad + "]";
	}
}