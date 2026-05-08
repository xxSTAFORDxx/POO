package Hospital_Infernal_5;

import java.util.ArrayList;
import java.util.Collections;

public class TestV5 {

	public static void main(String[] args) {

		// 1. Nuestra lista de hospitalizados
		ArrayList<Paciente_Hospitalizado> listaHospital = new ArrayList<>();

		// 2. Creamos los pacientes
		Paciente p1 = new Paciente("Dani", 100, 25, Sexo.MASCULINO, Gravedad.LEVE);
		Paciente p2 = new Paciente("Yago", 50, 30, Sexo.MASCULINO, Gravedad.MODERADA);
		Paciente p3 = new Paciente("Claudia", 200, 22, Sexo.FEMENINO, Gravedad.CRITICA);
		Paciente p4 = new Paciente("Marta", 150, 20, Sexo.FEMENINO, Gravedad.LEVE);

		System.out.println("====== 🏥 HOSPITAL INFERNAL 5: SISTEMA DE TRASPLANTES ======\n");

		// 3. HOSPITALIZACIÓN (Prueba de excepciones)
		try {
			listaHospital.add(p1.hospitalizar(new Medicamento("Paracetamol", Tipo_Medicamento.ANALGESICO)));
			listaHospital.add(p2.hospitalizar(new Medicamento("Ibuprofeno", Tipo_Medicamento.ANALGESICO)));
			listaHospital.add(p3.hospitalizar(new Medicamento("Morfina", Tipo_Medicamento.ANALGESICO)));
			listaHospital.add(p4.hospitalizar(new Medicamento("Amoxicilina", Tipo_Medicamento.ANTIBIOTICO)));

			// Prueba de error: Hospitalizar a alguien ya ingresado
			p1.hospitalizar(new Medicamento("Doble", Tipo_Medicamento.ANALGESICO));

		} catch (PacienteYaHospitalizadoException e) {
			System.err.println("Capturado: " + e.getMessage());
		}

		// 4. CONFIGURACIÓN DE DATOS (Para el CompareTo)
		listaHospital.get(0).setDiagnostico(Diagnostico.ALERGIA);
		listaHospital.get(0).setDiasHospitalizado(2);

		listaHospital.get(1).setDiagnostico(Diagnostico.ESGUINCE);
		listaHospital.get(1).setDiasHospitalizado(5);

		listaHospital.get(2).setDiagnostico(Diagnostico.DIABETES);
		listaHospital.get(2).setDiasHospitalizado(10);

		listaHospital.get(3).setDiagnostico(Diagnostico.TOS);
		listaHospital.get(3).setDiasHospitalizado(1);

		// 5. BÚSQUEDA AUTOMÁTICA DE DONANTE (Recorriendo la lista)
		Paciente_Hospitalizado receptor = listaHospital.get(2); // Claudia
		Tipo_Organo organoBusca = Tipo_Organo.RIÑON;

		System.out.println("\n--- Buscando donante de " + organoBusca + " para " + receptor.getNombre() + " ---");

		for (Paciente_Hospitalizado posibleDonante : listaHospital) {
			if (posibleDonante.equals(receptor))
				continue; // No donarse a uno mismo

			try {
				// El método solicitarTrasplante lanzará tus excepciones si algo falla
				Trasplante t = receptor.solicitarTrasplante(posibleDonante, organoBusca);
				System.out.println("✅ ¡Éxito! Trasplante listo con " + posibleDonante.getNombre());
				break;

			} catch (DonanteNoCompatibleException e) {
				System.out.println("❌ " + posibleDonante.getNombre() + " rechazado: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("⚠️ Error médico con " + posibleDonante.getNombre() + ": " + e.getMessage());
			}
		}

		// 6. ORDENACIÓN Y LISTADO FINAL
		System.out.println("\n--- PACIENTES POR PRIORIDAD (Gravedad -> Días -> Diagnóstico) ---");
		Collections.sort(listaHospital);

		for (Paciente_Hospitalizado ph : listaHospital) {
			System.out.println(ph.getGravedad() + " | Días: " + ph.getDiasHospitalizado() + " | " + ph.getNombre()
					+ " | Diag: " + ph.getDiagnostico());
		}
		
		// Creamos los médicos
		Medico house = new Medico("Dr. House", Categoria.ESPECIALISTA, 20);
		Medico shaun = new Medico("Dr. Shaun", Categoria.RESIDENTE, 5);

		// Elegimos un paciente de nuestra lista
		Paciente_Hospitalizado victima = listaHospital.get(0);

		// Creamos el objeto Operación y la ejecutamos
		Operacion quirofano = new Operacion(victima, house, shaun);
		quirofano.realizarOperacion();
	}
}