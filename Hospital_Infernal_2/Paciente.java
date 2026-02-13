package Hospital_Infernal_2;

import java.util.ArrayList;

import Hospital_Infernal_2.Gravedad;
import Hospital_Infernal_2.Planta;

public class Paciente extends Persona {
	double dinero;
	ArrayList<Sintoma> sintomas;
	Planta planta;
	Gravedad gravedad;

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
		if(s.gravedad.ordinal() > this.gravedad.ordinal())
			this.gravedad= s.gravedad;
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