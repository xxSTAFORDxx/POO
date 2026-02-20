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
		if (s.gravedad.getNivel() > this.gravedad.getNivel()) {
	        this.gravedad = s.gravedad;
	        System.out.println("Atención: La gravedad de " + this.nombre + " ha subido a " + this.gravedad);
	    	
	        //if(s.gravedad.ordinal() > this.gravedad.ordinal())
			//	this.gravedad= s.gravedad;
	        //---------------------------------------------------------------------------------
	        //if (s.gravedad == Gravedad.CRITICA) {
	        //     Si el síntoma es crítico, el paciente pasa a crítico siempre
	        //    this.gravedad = Gravedad.CRITICA;
	       // } 
	       // else if (s.gravedad == Gravedad.GRAVE) {
	       //         Solo subimos a GRAVE si el paciente estaba en algo inferior
	        //    if (this.gravedad == Gravedad.MODERADA || this.gravedad == Gravedad.LEVE) {
	        //        this.gravedad = Gravedad.GRAVE;
	        //    }
	       // } 
	      //  else if (s.gravedad == Gravedad.MODERADA) {
	     //        Solo subimos a MODERADA si el paciente estaba LEVE
	       //     if (this.gravedad == Gravedad.LEVE) {
	        //        this.gravedad = Gravedad.MODERADA;
	       //     }
	      //  }
	        
		}
	}
			
public Paciente_Hospitalizado hospitalizar(String tratamiento) {
        
        //si nosaltres mateixos no som de classe PacientHospitalitzat
        if(!(this instanceof Paciente_Hospitalizado)) {
        	Paciente_Hospitalizado nuevoPaciente = new Paciente_Hospitalizado(this, tratamiento);
            System.out.println(this.nombre + " ha sido hospitalizado.");
            return nuevoPaciente;
        }else{
            //El pacient ja està hospitalitzat
            System.out.println("Aquest pacient ja està hospitalitzat");
            //podem castejar perque estem segurs de que es un PacientHospitalitzat gracies al instanceof
            return (Paciente_Hospitalizado) this;
        }
	}
}