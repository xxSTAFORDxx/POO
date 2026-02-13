package Hospital_Infernal_2;

import Hospital_Infernal_2.Medico;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Medico marc = new Medico("Marc");
		Paciente yago = new Paciente("Yago");
		yago.hospitalizar(null);
		System.out.println(yago instanceof Medico);
		System.out.println(yago instanceof Persona);
		System.out.println(yago instanceof Paciente);

		marc.diElNombre();

		Paciente_Hospitalizado dani = new Paciente_Hospitalizado("Dani", 35);
        System.out.println(dani.nombre);
        dani.diElNombre();
        marc.consulta(dani); //aquí “marc” recuperem el metge creat a Hospital 1
		
	}

}