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
			System.out.println("1. Introdueix el alumne i la nota");
			System.out.println("2. Calcula la nota mitjana");
			System.out.println("3. Mostrar els aprovats");
			System.out.println("4. Mostrar els suspesos");
			System.out.println("5. Buscar un alumne");
			System.out.println("6. Modificar la nota");
			System.out.println("7. Mostrar les estadistiques");
			System.out.println("8. Sortir del programa");
			System.out.println("-----------");
			System.out.println("-----------");
			System.out.println("Escull una opcio:");
			int opcio = sc.nextInt();

			switch (opcio) {
			case 1:
				notaAlumne();
				break;
			case 2:
				double NotaMitjana = notaMitjana(); {
					System.out.println("La nota mitjana es de " + NotaMitjana);
				}
				break;
			case 3:
				mostrarAprovats();
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
				sortir = true;
				break;
			}
		}
	}

	public static void notaAlumne() {
		sc.nextLine();

		System.out.println("Digues el nom del alumne");
		String nomAlumne = sc.nextLine();
		if (!nomAlumne.isEmpty() && !listaNom.contains(nomAlumne)) {
			listaNom.add(nomAlumne);
		}
		System.out.println("Digues la nota de " + nomAlumne);
		double notaAlumne = sc.nextInt();
		if (notaAlumne >=0 && notaAlumne <=10) {
			listaNota.add(notaAlumne);
		}
	}

	public static Double notaMitjana() {
		
		double accNota = 0;
		for (double i = 0; i < listaNota.size(); i++) {
			accNota += listaNota.get(i);}
		double NotaMitjana = accNota / listaNota.size();
		 return NotaMitjana;
	}

	public static void mostrarAprovats() {
for (double i=0; i<listaNota.size(); i++) {
	if (listaNota.get(i) >= 5)
	System.out.println(listaNota.get(i));
}
	}

	public static void mostrarSuspesos() {

	}

	public static void buscarAlumne() {

	}

	public static void modificarNota() {

	}

	public static void mostrarEstadistiques() {

	}

}
