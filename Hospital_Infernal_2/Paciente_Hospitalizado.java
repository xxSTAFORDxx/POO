package Hospital_Infernal_2;

//extends Pacient implica que és filla de Pacient, i hereta tots els 
//mètodes i atributs de Pacient 

public class Paciente_Hospitalizado extends Paciente {
	// posem només els atributs nous, no els de Pacient. És a dir, posem
	// els atributs que tindrà PacientHospitalitzat, però no Pacient
	public String tratamientoActual;
	public int diasHospitalizado;

	public Paciente_Hospitalizado(String nombre, int edad) {
		// cridem al constructor idèntic del pare
		super(nombre, edad);
		// la resta de variables les posem nosaltres
		this.tratamientoActual = "Observació";
		this.diasHospitalizado = 0;

	}
}
