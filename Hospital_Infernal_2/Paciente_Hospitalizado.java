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
		this.tratamientoActual = "Observacion";
		this.diasHospitalizado = 0;

	}

	public Paciente_Hospitalizado(Paciente pac, String tratamiento) {
		super(pac.nombre, pac.edad);
		this.tratamientoActual = tratamiento;
		this.diasHospitalizado = 0;
	}
	
	public void añadirSintoma(Sintoma s) {
		super.añadirSintoma(s);
		this.diasHospitalizado = 1;	
	}
	
    public Paciente_Hospitalizado hospitalizar(String tratramiento) {
        
        //si nosaltres mateixos no som de classe PacientHospitalitzat
        if(!(this instanceof Paciente_Hospitalizado)) {
            //hospitalitzar el Pacient. Això ho heu de fer vosaltres
            //Has de crear un PacientHospitalitzat fent servir el propi Pacient. potser algun dels constructors de PacientHospitalitzatet serveix…
        }else{
            //El pacient ja està hospitalitzat
            System.out.println("Aquest pacient ja està hospitalitzat");
            //podem castejar perque estem segurs de que es un PacientHospitalitzat gracies al instanceof
            return (Paciente_Hospitalizado) this;
        }
    }

	
}
