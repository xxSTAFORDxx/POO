package Funcions;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorDeNotes {

	static ArrayList<String> listaNom = new ArrayList<>();
	static ArrayList<Double> listaNota = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("GESTOR DE NOTES");

		boolean sortir = false;
		while (!sortir) {
			System.out.println("                                 ");
			System.out.println("1. Introdueix el alumne i la nota.");
			System.out.println("2. Calcula la nota mitjana.");
			System.out.println("3. Mostrar els aprovats.");
			System.out.println("4. Mostrar els suspesos.");
			System.out.println("5. Buscar un alumne.");
			System.out.println("6. Modificar la nota.");
			System.out.println("7. Mostrar les estadistiques.");
			System.out.println("8. Mostrar els alumnes ordenats per nom.");
			System.out.println("9. Mostrar els alumnes ordenats per nota.");
			System.out.println("10. Eliminar alumne.");
			System.out.println("11. Sortir del programa.");
			System.out.println("-----------");
			System.out.println("-----------");
			System.out.println("Escull una opcio:");
			int opcio = sc.nextInt();
			sc.nextLine();
			System.out.println("                                 ");
			switch (opcio) {
			case 1:
				notaAlumne();
				break;
			case 2:
				double NotaMitjana = notaMitjana(); {
				System.out.println("La nota mitjana es de " + NotaMitjana + ".");
				System.out.println("                                    ");
			}
				break;
			case 3:
				mostrarAprovats(); {
			}
				break;
			case 4:
				mostrarSuspesos();
				break;
			case 5:
				buscarAlumne();
				break;
			case 6:
				modificarNota();
				break;
			case 7:
				mostrarEstadistiques();
				break;
			case 8:
				alumnesOrdenats();
			case 9:
				notesOrdenades();
			case 10:
				eliminarAlumne();
				break;
			case 11:
				sortir = true;
				break;
			}
		}
	}

	public static void notaAlumne() {
		sc.nextLine();

		System.out.println("Digues el nom del alumne.");
		System.out.println("                        ");
		String nomAlumne = sc.nextLine();
		if (!nomAlumne.isEmpty() && !listaNom.contains(nomAlumne)) {
			listaNom.add(nomAlumne);
			System.out.println("Digues la nota de " + nomAlumne + ".");
			System.out.println("                              ");
			double notaAlumne = sc.nextDouble();
			sc.nextLine();
			if (notaAlumne >= 0 && notaAlumne <= 10) {
				listaNota.add(notaAlumne);

			} else
				System.out.println("Nota incorrecta");
		}
	}

	public static Double notaMitjana() {

		double accNota = 0;
		for (int i = 0; i < listaNota.size(); i++) {
			accNota += listaNota.get(i);
		}
		double NotaMitjana = accNota / listaNota.size();
		return NotaMitjana;
	}

	public static void mostrarAprovats() {
		sc.nextLine();
		int acc = 0;
		for (int i = 0; i < listaNota.size(); i++) {
			if (listaNota.get(i) >= 5) {
				acc++;
				System.out.println("Nom: " + listaNom.get(i) + " " + "Nota: " + listaNota.get(i) + ".");
				System.out.println("                                                           ");
			}
		}
		if (acc == 0) {
			System.out.println("No hi ha aprovats.");
			System.out.println("                  ");
		}
	}

	public static void mostrarSuspesos() {
		sc.nextLine();
		int acc = 0;
		for (int i = 0; i < listaNota.size(); i++) {
			if (listaNota.get(i) < 5) {
				acc++;
				System.out.println("Nom: " + listaNom.get(i) + " " + "Nota: " + listaNota.get(i) + ".");
				System.out.println("                                                           ");
			}
		}
		if (acc == 0) {
			System.out.println("No hi ha suspesos.");
			System.out.println("                  ");
		}
	}

	public static void buscarAlumne() {
		sc.nextLine();
		System.out.println("Digues el nom del alumne.");
		System.out.println("                         ");
		String nom = sc.nextLine();
		int acc = 0;
		for (int i = 0; i < listaNom.size(); i++) {
			if (listaNom.get(i).equals(nom)) {
				acc++;
				System.out.println("L'alumne " + listaNom.get(i) + " té de nota un " + listaNota.get(i) + ".");
				System.out.println("                                                                  ");
			}
		}
		if (acc == 0) {
			System.out.println("L'alumne " + nom + " no existeix.");
			System.out.println("                              ");
		}
	}

	public static void modificarNota() {
		sc.nextLine();
		System.out.println("Digues el nom del alumne.");
		System.out.println("                         ");
		String nom = sc.nextLine();
		System.out.println("Digues la nova nota del alumne.");
		System.out.println("                          ");
		Double nota = sc.nextDouble();
		sc.nextLine();
		boolean trobat = false;
		if (nota >= 0 && nota <= 10) {
			for (int i = 0; i < listaNom.size(); i++) {
				if (listaNom.get(i).equals(nom)) {
					listaNota.set(i, nota);
					trobat = true;
					break;
				}
			}
			if (!trobat) {
				System.out.println("L'alumne no existeix.");
				System.out.println("                     ");
			}
		}
	}

	public static void mostrarEstadistiques() {

		if (listaNom.size() > 0) {
			System.out.println("Aquests son el total de alumnes " + listaNom.size());
			int aprovats = 0;
			double notaMax = -100;
			double notaMin = 100;
			for (int i = 0; i < listaNota.size(); i++) {
				if (listaNota.get(i) > notaMax) {
					notaMax = listaNota.get(i);
				}
				if (listaNota.get(i) < notaMin) {
					notaMin = listaNota.get(i);
				}
				if (listaNota.get(i) >= 5) {
					aprovats++;
				}
			}
			double percentatge = aprovats * 100.0 / listaNota.size();
			System.out.println("Nota màxima: " + notaMax);
			System.out.println("Nota mínima: " + notaMin);
			System.out.println("Precentatge d'aprovats: " + percentatge + "%");
			System.out.println("Total de suspesos: " + (listaNota.size() - aprovats));

		} else {
			System.out.println("No hi ha alumnes registrats.");
		}
	}
	public static void alumnesOrdenats() {

	}

	public static void notesOrdenades() {

	}
	public static void eliminarAlumne() {
		System.out.println("Introdueix el nom del alumne a esborrar.");
		System.out.println("                            ");
		String nom = sc.nextLine();
		for (int i = 0; i < listaNom.size(); i++) {
			if (listaNom.get(i).equals(nom)) {
				listaNom.remove(i);
				listaNota.remove(i);
			}
		}
	}

}