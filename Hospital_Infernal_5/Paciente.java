package Hospital_Infernal_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Paciente extends Persona {

	private double dinero;
	private int edad;
	private ArrayList<Sintoma> sintomas = new ArrayList<>();
	private HashMap<Tipo_Organo, Boolean> organos = new HashMap<>();
	private Planta planta;
	private Gravedad gravedad;
	private Sexo sexo;
	static String estatic;

	public Paciente(String nombre) {
		super(nombre);
	}

	public Paciente(String nombre, double dinero, int edad, Sexo sexo, Gravedad gravedad) {
		super(nombre);
		this.dinero = dinero;
		this.edad = edad;
		this.sexo = sexo;
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
		comprobacionOrganos();
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
		this.gravedad = Gravedad.LEVE;
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

	public Paciente_Hospitalizado hospitalizar(Tratamiento tratamiento) throws PacienteYaHospitalizadoException {
		if (!(this instanceof Paciente_Hospitalizado)) {
			Paciente_Hospitalizado nuevoPaciente = new Paciente_Hospitalizado(this, tratamiento);
			System.out.println(this.getNombre() + " ha sido hospitalizado con éxito.");
			return nuevoPaciente;
		} else {
			throw new PacienteYaHospitalizadoException(
					"¡ERROR! El paciente " + this.getNombre() + " ya se encuentra en una planta del hospital.");
		}
	}

	private void comprobacionOrganos() {
		Random random = new Random();
		int limite;
		if (this.getEdad() <= 1 && this.planta == Planta.NEONATAL)
			limite = 5;
		else if (this.getEdad() <= 18 && this.planta == Planta.PEDIATRIA)
			limite = 15;
		else if (this.getEdad() <= 74 && this.planta == Planta.GENERAL)
			limite = 35;
		else
			limite = 60;
		this.organos.clear();
		for (Tipo_Organo tipo : Tipo_Organo.values()) {
			boolean falla = random.nextInt(100) < limite;
			this.organos.put(tipo, !falla);
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
		if (nuevaGravedad == null) {
	        System.out.println(getNombre() + " ha muerto.");
	    } else {
	        System.out.println("El estado de " + getNombre() + " ha cambiado a " + nuevaGravedad);
	    }
	    this.gravedad = nuevaGravedad;
	}

	public ArrayList<Sintoma> getSintomas() {
		return sintomas;
	}

	public Planta getPlanta() {
		return planta;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public HashMap<Tipo_Organo, Boolean> getOrganos() {
		return organos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, gravedad, organos, sexo, sintomas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return edad == other.edad && gravedad == other.gravedad && Objects.equals(organos, other.organos)
				&& sexo == other.sexo && Objects.equals(sintomas, other.sintomas);
	}

	public int compareTo(Object arg0) {
		Paciente otro = (Paciente) arg0;
		if (otro.edad > this.edad) {
			return -1;
		} else if (this.edad > otro.edad) {
			return 1;
		}
		else {
			return this.getNombre().compareTo(otro.getNombre());
		}
	}
	
	public String toString() {
		return super.toString() + "Paciente [dinero=" + dinero + ", edad=" + edad + ", sintomas=" + sintomas
				+ ", planta=" + planta + ", gravedad=" + gravedad + "]";
	}
}