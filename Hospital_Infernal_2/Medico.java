package Hospital_Infernal_2;

public class Medico extends Persona {

	int añosTrabajados;
    double sueldo;

    public Medico(String nombre) {
        super(nombre); 
        this.añosTrabajados = 0;
        this.sueldo = 1000.0;
    }
}