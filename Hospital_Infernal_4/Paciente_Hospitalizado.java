package Hospital_Infernal_4;

import java.util.ArrayList;

public class Paciente_Hospitalizado extends Paciente {

	private ArrayList<Tratamiento> tratamientosActuales = new ArrayList<>();
	private int diasHospitalizado;
	static int nombrePacientesHospitalizados = 0;
	private Diagnostico diagnostico;
	private Intervencion intervencionAsignada;

	public Paciente_Hospitalizado(Paciente pac) {
		super(pac.getNombre(), pac.getDinero(), pac.getEdad(), pac.getGravedad());
		this.tratamientosActuales.add(new Medicamento("Paracetamol", Tipo_Medicamento.ANALGESICO));
		this.diasHospitalizado = 0;
		nombrePacientesHospitalizados++;
	}

	public Paciente_Hospitalizado(String nombre, int edad) {
		super(nombre, edad);
		this.tratamientosActuales.add(new Medicamento("Paracetamol", Tipo_Medicamento.ANALGESICO));
		this.diasHospitalizado = 0;
	}

	public Paciente_Hospitalizado(Paciente pac, Tratamiento tratamiento) {
		super(pac.getNombre(), pac.getDinero(), pac.getEdad(), pac.getGravedad());
		this.tratamientosActuales.add(tratamiento);
		this.diasHospitalizado = 0;
		nombrePacientesHospitalizados++;
	}

	public void añadirSintoma(Sintoma s) {
		super.añadirSintoma(s);
		this.diasHospitalizado = 1;
	}

	public ArrayList<Tratamiento> getTratamientosActuales() {
		return tratamientosActuales;
	}

	public void reduirGravetat() {
		if (getGravedad().equals(Gravedad.LEVE)) {
			setGravedad(Gravedad.LEVE);
		}
		if (getGravedad().equals(Gravedad.MODERADA)) {
			setGravedad(Gravedad.LEVE);
		}
		if (getGravedad().equals(Gravedad.GRAVE)) {
			setGravedad(Gravedad.MODERADA);
		}
		if (getGravedad().equals(Gravedad.CRITICA)) {
			setGravedad(Gravedad.GRAVE);
		}
	}

	public void augmentarGravetat() {
		if (getGravedad().equals(Gravedad.CRITICA)) {
			setGravedad(Gravedad.CRITICA);
		}
		if (getGravedad().equals(Gravedad.GRAVE)) {
			setGravedad(Gravedad.CRITICA);
		}
		if (getGravedad().equals(Gravedad.MODERADA)) {
			setGravedad(Gravedad.GRAVE);
		}
		if (getGravedad().equals(Gravedad.LEVE)) {
			setGravedad(Gravedad.MODERADA);
		}
	}

	public void administrarTratamiento(Tratamiento tra) {
		if (tratamientosActuales.contains(tra)) {
			tra.administrar(this);
		}
	}

	public void setTratamientoActual(Tratamiento nuevoTratamiento) {
		this.tratamientosActuales.add(nuevoTratamiento);
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

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
	    this.diagnostico = diagnostico;
	}
	
	public Intervencion getIntervencionAsignada() {
		return intervencionAsignada;
	}

	public void setIntervencionAsignada(Intervencion intervencionAsignada) {
		this.intervencionAsignada = intervencionAsignada;
	}

	public String toString() {
		return super.toString() + "Paciente_Hospitalizado [tratamientoActual=" + tratamientosActuales
				+ ", diasHospitalizado=" + diasHospitalizado + "]";
	}
}
