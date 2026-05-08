package Hospital_Infernal_5;

import java.util.ArrayList;
import java.util.Objects;

public class Paciente_Hospitalizado extends Paciente implements Comparable {

	private ArrayList<Tratamiento> tratamientosActuales = new ArrayList<>();
	private int diasHospitalizado;
	static int nombrePacientesHospitalizados = 0;
	private Diagnostico diagnostico;
	private Intervencion intervencionAsignada;

	public Paciente_Hospitalizado(Paciente pac) {
		super(pac.getNombre(), pac.getDinero(), pac.getEdad(), pac.getSexo(), pac.getGravedad());
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
		super(pac.getNombre(), pac.getDinero(), pac.getEdad(), pac.getSexo(), pac.getGravedad());
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

	public boolean esCompatible(Tipo_Organo organo, Paciente_Hospitalizado receptor, Paciente_Hospitalizado donante)
			throws Exception {
		if (!donante.getOrganos().get(organo))
			throw new DonanteNoCompatibleException("El donante no tiene el órgano sano.");
		if (receptor.getOrganos().get(organo))
			throw new DonanteNoCompatibleException("El receptor ya tiene este órgano sano.");
		if (receptor.getGravedad() == Gravedad.CRITICA)
			throw new ReceptorCriticoException("El receptor está en estado CRÍTICO, es muy peligroso.");
		if (donante.getGravedad() != Gravedad.LEVE)
			throw new DonanteNoLeveException("El donante debe tener gravedad LEVE.");
		if (receptor.getSexo() != donante.getSexo())
			throw new SexoNoCompatibleException("Los sexos no coinciden.");
		return true;
	}

	public Trasplante solicitarTrasplante(Paciente_Hospitalizado paciente, Tipo_Organo organo) throws Exception {
		Paciente_Hospitalizado donante = null;
		if (esCompatible(organo, this, paciente)) {
			donante = paciente;
		}
		if (donante == null) {
			throw new Exception("Error: El donante no es compatible para el trasplante de " + organo);
		} else {
			return new Trasplante(organo, donante, this);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diagnostico, diasHospitalizado, tratamientosActuales);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente_Hospitalizado other = (Paciente_Hospitalizado) obj;
		return diagnostico == other.diagnostico && diasHospitalizado == other.diasHospitalizado
				&& Objects.equals(tratamientosActuales, other.tratamientosActuales);
	}

	@Override
	public int compareTo(Object arg0) {
		Paciente_Hospitalizado otro = (Paciente_Hospitalizado) arg0;
		if (this.getGravedad().ordinal() != otro.getGravedad().ordinal()) {
			return Integer.compare(otro.getGravedad().ordinal(), this.getGravedad().ordinal());
		}
		if (this.getDiasHospitalizado() != otro.getDiasHospitalizado()) {
			return Integer.compare(otro.getDiasHospitalizado(), this.getDiasHospitalizado());
		}
		if (this.getDiagnostico() != null && otro.getDiagnostico() != null) {
			return this.getDiagnostico().name().compareTo(otro.getDiagnostico().name());
		}
		return 0;
	}

	@Override
	public String toString() {
		return String.format("%-10s | Días: %-2d | %-8s | Diag: %s", getGravedad(), diasHospitalizado, getNombre(),
				getDiagnostico());
	}
}