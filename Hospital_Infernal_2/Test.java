package Hospital_Infernal_2;

import Hospital_Infernal.Medico;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Medico marc = new Medico();
		marc.nombre = "Marc";
		marc.diElNombre();

		Paciente_Hospitalizado dani = new Paciente_Hospitalizado("Dani", 35);
        System.out.println(dani.nombre);
        dani.diElNombre();
        marc.consulta(dani); //aquí “marc” recuperem el metge creat a Hospital 1
		
	}

}