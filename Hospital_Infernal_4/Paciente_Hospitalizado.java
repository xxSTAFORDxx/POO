package Hospital_Infernal_4;

import java.util.ArrayList;

public class Paciente_Hospitalizado extends Paciente {

	private ArrayList<Tratamiento> tratamientosActuales = new ArrayList<>();
	private int diasHospitalizado;
	static int nombrePacientesHospitalizados = 0;

	public Paciente_Hospitalizado(Paciente pac) {
		super(pac.getNombre(), pac.getDinero(), pac.getEdad(), pac.getGravedad());
		this.tratamientosActuales.add(new Tratamiento("Observacion"));
		this.diasHospitalizado = 0;
		nombrePacientesHospitalizados++;
	}

	public Paciente_Hospitalizado(String nombre, int edad) {
		super(nombre, edad);
		this.tratamientosActuales.add(new Tratamiento("Observacion"));
		this.diasHospitalizado = 0;
	}

	public Paciente_Hospitalizado(Paciente pac, String tratamiento) {
		super(pac.getNombre(), pac.getDinero(), pac.getEdad(), pac.getGravedad());
		this.tratamientosActuales.add(new Tratamiento(tratamiento));
		this.diasHospitalizado = 0;
	}

	public void añadirSintoma(Sintoma s) {
		super.añadirSintoma(s);
		this.diasHospitalizado = 1;
	}

	public  getTratamientoActual() {
		return arrayList Tratamiento;
	}

	public void setTratamientoActual(String nuevoTratamiento) {
		this.tratamientosActuales = nuevoTratamiento;
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

	public String toString() {
		return super.toString() + "Paciente_Hospitalizado [tratamientoActual=" + tratamientosActuales
				+ ", diasHospitalizado=" + diasHospitalizado + "]";
	}
}
