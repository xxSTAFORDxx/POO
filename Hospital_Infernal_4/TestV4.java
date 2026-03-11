package Hospital_Infernal_4;

public class TestV4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. PREPARACIÓN DE DATOS BÁSICOS
        Paciente p1 = new Paciente("Dani", 500, 30, Gravedad.GRAVE);
        
        // Hospitalizamos a Dani con un tratamiento inicial (Paracetamol que viene por defecto)
        Paciente_Hospitalizado daniHospi = new Paciente_Hospitalizado(p1);
        daniHospi.setDiagnostico(Diagnostico.IBACTERIANA); // Le damos un diagnóstico

        System.out.println("--- ESCENARIO 1: Administración de Medicamentos ---");
        // Creamos un Antibiótico (Alta coherencia con IBACTERIANA)
        Medicamento amoxicilina = new Medicamento("Amoxicilina", Tipo_Medicamento.ANTIBIOTICO);
        daniHospi.setTratamientoActual(amoxicilina);
        
        System.out.println("Estado inicial: " + daniHospi.getGravedad());
        // Intentamos administrarlo
        daniHospi.administrarTratamiento(amoxicilina);
        System.out.println("Estado tras antibiótico (debería mejorar si hubo éxito): " + daniHospi.getGravedad());

        System.out.println("\n--- ESCENARIO 2: Coherencia y Probabilidades ---");
        // Creamos una Terapia TIMO (Efectividad 0% según enunciado)
        Terapia homeopatia = new Terapia("Terapia de Cristales", Tipo_Terapia.TIMO);
        daniHospi.setTratamientoActual(homeopatia);
        
        System.out.println("Probando Terapia TIMO...");
        daniHospi.administrarTratamiento(homeopatia);
        System.out.println("Estado tras TIMO (no debería haber cambiado): " + daniHospi.getGravedad());

        System.out.println("\n--- ESCENARIO 3: Intervenciones y Seguridad ---");
        Cirugia bypass = new Cirugia("Bypass Coronario");

        // Intentamos asignar cuando NO es CRÍTICA
        System.out.println("¿Se puede asignar cirugía siendo " + daniHospi.getGravedad() + "? " + 
                            bypass.puedeAsignarse(daniHospi));

        // Forzamos estado CRÍTICO para probar la cirugía
        daniHospi.setGravedad(Gravedad.CRITICA);
        System.out.println("Estado forzado a: " + daniHospi.getGravedad());
        
        if (bypass.puedeAsignarse(daniHospi)) {
            // Al llamar a administrar, tu código de Cirugía llamará internamente a asignar(pac)
            daniHospi.administrarTratamiento(bypass); 
            System.out.println("Cirugía asignada correctamente.");
        }

        // Realizamos la cirugía
        System.out.println("Realizando cirugía...");
        bypass.realizar(daniHospi);
        System.out.println("Estado tras cirugía: " + daniHospi.getGravedad());
        System.out.println("¿Queda intervención pendiente?: " + (daniHospi.getIntervencionAsignada() != null));

        System.out.println("\n--- ESCENARIO 4: Detección de errores (instanceof) ---");
        // Añadimos una cirugía a la lista de TRATAMIENTOS (lo cual es un error según el enunciado)
        daniHospi.setTratamientoActual(new Cirugia("Apendicitis por error"));
        
        if (bypass.intervencionMalAplicada(daniHospi)) {
            System.out.println("¡ALERTA!: Se ha detectado una Intervención oculta en la lista de tratamientos.");
        } else {
            System.out.println("Todo correcto en la lista de tratamientos.");
        }

        System.out.println("\n--- ESCENARIO 5: Control de Cantidad ---");
        Medicamento poco = new Medicamento("Placebo", Tipo_Medicamento.ANALGESICO);
        // Administramos hasta que se agote (si tu lógica de administrar resta cantidad)
        daniHospi.setTratamientoActual(poco);
        System.out.println("Cantidad inicial: " + poco.getCantidad());
        daniHospi.administrarTratamiento(poco);
        System.out.println("Cantidad después de 1 uso: " + poco.getCantidad());

	}

}
