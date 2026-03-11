package Hospital_Infernal_3;

public class TestV3 {

	public static void main(String[] args) {

	    // 1. CREACIÓN DEL MÉDICO
	    // Creamos a Marc y lo subimos a ESPECIALISTA (Multiplicador x3)
	    Medico marc = new Medico("Marc");
	    marc.setDepartamento("Traumatologia");
	    marc.setCategoria(Categoria.ESPECIALISTA);

	    // 2. CREACIÓN DE PACIENTES CON DIFERENTES PERFILES
	    // Dani: Adulto sano con 100€ (Debe pagar 30€)
	    Paciente dani = new Paciente("Dani", 30);
	    dani.setDinero(100.0);

	    // Carla: Niña de 10 años (Debe ser GRATIS 0€)
	    Paciente carla = new Paciente("Carla", 10);
	    carla.setDinero(50.0);

	    // Joan: Paciente CRÍTICO (Debe ser GRATIS 0€)
	    Paciente joan = new Paciente("Joan", 45);
	    joan.setDinero(20.0);
	    joan.setGravedad(Gravedad.CRITICA);

	    // 3. PRUEBA DE CONSULTAS
	    System.out.println("--- INICIO DE CONSULTAS ---");
	    
	    // Marc atiende a Dani (Dani: 100€ -> 70€ | Marc: 1000€ -> 1000€)
	    marc.consulta(dani);

	    // Marc atiende a Carla (Gratis por edad: Carla sigue con 50€)
	    marc.consulta(carla);

	    // Marc atiende a Joan (Gratis por gravedad: Joan sigue con 20€)
	    marc.consulta(joan);

	    // 4. PRUEBA DE HOSPITALIZACIÓN (Conversión de objeto)
	    System.out.println("\n--- PRUEBA DE HOSPITALIZACIÓN ---");
	    
	    // Dani se agrava y lo hospitalizamos. 
	    // Importante: 'daniIngresado' es un nuevo objeto de tipo Paciente_Hospitalizado
	    Paciente_Hospitalizado daniIngresado = dani.hospitalizar("Repòs i observació");

	    // Probamos los métodos específicos de la subclase
	    daniIngresado.setDiasHospitalizado(1);
	    System.out.println("Paciente: " + daniIngresado.getNombre() + " | Días: " + daniIngresado.getDiasHospitalizado());

	    // 5. PRUEBA DE REGLAS DE NEGOCIO (Setters con filtros)
	    System.out.println("\n--- PRUEBA DE REGLAS DE CATEGORÍA ---");
	    
	    // Intentamos que Marc vuelva a ser INTERNO (Tu setter debería denegarlo y lanzar el SYSO de error)
	    marc.setCategoria(Categoria.INTERNO);
	    
	    // Verificamos el estado final del médico
	    System.out.println("Sueldo final de Marc: " + marc.getSueldo() + "€ (No debe haber subido)");
	    System.out.println("Pacientes en la lista de Marc: " + marc.getPacientsAssignats().size());
	}

}
