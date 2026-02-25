package Hospital_Infernal_3;

public class Paciente_Hospitalizado extends Paciente {

	private String tratamientoActual;
	private int diasHospitalizado;

	public Paciente_Hospitalizado(String nombre, int edad) {
		super(nombre, edad);
		this.tratamientoActual = "Observacion";
		this.diasHospitalizado = 0;
	}

	public Paciente_Hospitalizado(Paciente pac, String tratamiento) {
		super(pac.getNombre(), pac.getEdad());
		this.setGravedad(pac.getGravedad());
		this.tratamientoActual = tratamiento;
		this.diasHospitalizado = 0;
	}

	public void añadirSintoma(Sintoma s) {
		super.añadirSintoma(s);
		this.diasHospitalizado = 1;
	}

	public String getTratamientoActual() {
		return tratamientoActual;
	}

	public void setTratamientoActual(String nuevoTratamiento) {
		this.tratamientoActual = nuevoTratamiento;
	}

	public int getDiasHospitalizado() {
		return diasHospitalizado;
	}

	public void setDiasHospitalizado(int nuevoDiasHospitalizado) {
		if (nuevoDiasHospitalizado < getDiasHospitalizado()) {
			System.out.println("Error, el paciente " + getNombre() + " ya lleva " + getDiasHospitalizado() + " dias");
		} else if (nuevoDiasHospitalizado == getDiasHospitalizado()) {
			System.out.println("Lleva " + getDiasHospitalizado());
		} else {
			System.out.println("Lleva " + getDiasHospitalizado());
			this.diasHospitalizado = nuevoDiasHospitalizado;
		}

	}
}
