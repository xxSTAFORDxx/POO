
package Hospital_Infernal_5;

import java.util.Scanner;

public class Operacion {

	private Paciente_Hospitalizado paciente;
	private Medico medico1;
	private Medico medico2;
	private int pasoActual = 1;

	public Operacion(Paciente_Hospitalizado paciente, Medico medico1, Medico medico2) {
		this.paciente = paciente;
		this.medico1 = medico1;
		this.medico2 = medico2;
	}

	public void realizarOperacion() {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		int turno = determinarMedicoMasExperto(medico1, medico2);
		System.out.println("=== QUIRÓFANO: " + paciente.getNombre().toUpperCase() + " ===");
		while (!fin) {
			Medico actuante = (turno == 1) ? medico1 : medico2;
			System.out
					.println("\nTURNO DE: " + actuante.getNombre() + " | PASO REQUERIDO: " + nombreAccion(pasoActual));
			int accion = elegirAccionMedico(sc);
			if (accion == -1) {
				System.out.println("Cirugía cancelada.");
				fin = true;
				continue;
			}
			if (accion != pasoActual) {
				System.out.println("ORDEN INCORRECTO. El protocolo exige primero: " + nombreAccion(pasoActual));
			} else {
				boolean exito = gestionarIntervencion(actuante, turno, accion);
				if (exito) {
					System.out
							.println("✅ El paso de " + nombreAccion(pasoActual) + " se ha completado correctamente.");
					pasoActual++;
					if (pasoActual > 4) {
						System.out.println("¡OPERACIÓN COMPLETADA CON ÉXITO! El paciente está estable.");
						fin = true;
					}
				} else {
					System.out.println("¡FALLO MÉDICO! La gravedad empeora.");
					empeorarPaciente();
				}
			}
			if (paciente.getGravedad() == null) {
				fin = true;
			} else if (!fin) {
				turno = (turno == 1) ? 2 : 1;
			}
		}
	}

	private String nombreAccion(int paso) {
		switch (paso) {
		case 1:
			return "Anestesiar";
		case 2:
			return "Abrir con bisturí";
		case 3:
			return "Limpiar sangre";
		case 4:
			return "Suturar";
		default:
			return "Cirugía finalizada";
		}
	}

	private int determinarMedicoMasExperto(Medico m1, Medico m2) {
		return (m1.getAñosTrabajados() >= m2.getAñosTrabajados()) ? 1 : 2;
	}

	private int elegirAccionMedico(Scanner sc) {
		int seleccion = -1;
		while (true) {
			try {
				System.out.println(" Acciones:");
				System.out.println("1-Anestesia.");
				System.out.println("2-Bisturí.");
				System.out.println("3-Limpiar.");
				System.out.println("4-Suturar.");
				System.out.println("5-Finalizar");
				System.out.print("Seleccione siguiente paso: ");
				seleccion = sc.nextInt();
				if (seleccion >= 1 && seleccion <= 5) {
					return (seleccion == 5) ? -1 : seleccion;
				} else {
					System.out.println("Opción no válida. Elija un número entre 1 y 5.");
				}
			} catch (Exception e) {
				System.out.println("ERROR: Entrada no válida. Use números, no letras.");
				sc.next();
			}
		}
	}

	private boolean gestionarIntervencion(Medico m, int turno, int accion) {
		int puntosExito = 0;
		if (m.getCategoria() == Categoria.INTERNO)
			puntosExito += 10;
		else if (m.getCategoria() == Categoria.RESIDENTE)
			puntosExito += 20;
		else if (m.getCategoria() == Categoria.ESPECIALISTA)
			puntosExito += 30;
		if (paciente.getGravedad() == Gravedad.LEVE)
			puntosExito += 30;
		else if (paciente.getGravedad() == Gravedad.MODERADA)
			puntosExito += 20;
		else if (paciente.getGravedad() == Gravedad.GRAVE)
			puntosExito += 10;
		else
			puntosExito += 0;
		int random = (int) (Math.random() * 51);
		return random < puntosExito;
	}

	private void empeorarPaciente() {
		Gravedad actual = paciente.getGravedad();
		if (actual == Gravedad.LEVE)
			paciente.setGravedad(Gravedad.MODERADA);
		else if (actual == Gravedad.MODERADA)
			paciente.setGravedad(Gravedad.GRAVE);
		else if (actual == Gravedad.GRAVE)
			paciente.setGravedad(Gravedad.CRITICA);
		else {
			System.err.println("¡TRAGEDIA! El paciente ha muerto.");
			paciente.setGravedad(null);
		}
	}

	private boolean finIntervencion(boolean exito, int accion) {
		return !exito || accion == -1 || paciente.getGravedad() == null;
	}
}