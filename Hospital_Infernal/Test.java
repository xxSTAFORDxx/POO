package Hospital_Infernal;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Medico marc = new Medico();
		marc.nombre = "Marc";
		marc.diElNombre();
		marc.añosTrabajados = 10;
		System.out.println(marc.añosTrabajados);
		marc.augmentarAñosTrabajados();
		System.out.println(marc.añosTrabajados);
	
		Medico faustino =new Medico(); 
		faustino.nombre ="Dr.Faustino";
		faustino.sueldo =1000;
		System.out.println(faustino.sueldo);
		faustino.augmentarAñosTrabajados();
		faustino.augmentarAñosTrabajados();
		faustino.augmentarAñosTrabajados();
		faustino.augmentarAñosTrabajados();
		faustino.augmentarAñosTrabajados();
		faustino.augmentarAñosTrabajados();
		System.out.println(faustino.sueldo);
		
		 Medico perDefecte = new Medico();
	        System.out.println(perDefecte.nombre);
	        Medico house = new Medico("House");
	        System.out.println(house.nombre+" "+house.sueldo);
	        Medico wilson = new Medico("Wilson", 10);  
	        System.out.println(wilson.nombre+" "+wilson.añosTrabajados);
	        
	        
	        Medico marc = new Medico("marc", Categoria.ESPECIALISTA);
	        System.out.println(marc.nombre+" "+marc.sueldo);
	        if(marc.categoria == Categoria.ESPECIALISTA) {
	            System.out.println("Marc es un Especialista!");
	        }

Medico faustino = new Medico("Dr. Faustino", "General", 1000.0, 0);
        
        System.out.println("Sueldo Faustino (esperado aprox 1181.37): " + faustino.sueldo);

        Medico house = new Medico("Dr. House", Categoria.ESPECIALISTA);
        Paciente p = new Paciente("Juan", 100.0, 20, Gravedad.LEVE);
        
        System.out.println("Dinero Juan antes: " + p.sueldo);
        house.consulta(p);
        System.out.println("Dinero Juan después: " + p.sueldo);
        System.out.println("Sueldo House después de cobrar: " + house.sueldo);
   
	}

}
