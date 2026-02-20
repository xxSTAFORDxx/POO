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

	public void setTratamientoActual(String tratamientoActual) {
		this.tratamientoActual = tratamientoActual;
	}

	public int getDiasHospitalizado() {
		return diasHospitalizado;
	}

	public void setDiasHospitalizado(int diasHospitalizado) {
		this.diasHospitalizado = diasHospitalizado;
	}

}
