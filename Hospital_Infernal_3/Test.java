package Hospital_Infernal_3;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        
        
        Paciente p1 = new Paciente("Yago", 29);

     // p1 es un Paciente normal. Ahora lo hospitalizamos:
     Paciente_Hospitalizado yagoiEnPlanta = p1.hospitalizar("Reposo total");

     // Ahora daniEnPlanta tiene acceso a 'diasHospitalizado', cosa que p1 no tenía.
		
	}

}