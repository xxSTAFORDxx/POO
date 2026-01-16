package Funcions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Repartiments {
	static ArrayList<Integer> repartiments = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("CONTROL DE REPARTIMENTS");

		boolean sortir = false;
		while (!sortir) {

			System.out.println(repartiments);
			System.out.println("1. REGISTRAR REPARTIMENT");
			System.out.println("2. VEURE TEMPS TOTAL");
			System.out.println("3. COMPTAR REPARTIMENTS");
			System.out.println("4. MES LENT");
			System.out.println("5. MES RAPID");
			System.out.println("6. TEMPS MITJA");
			System.out.println("7· SORTIR DEL PROGRAMA");
			System.out.println("-----------");
			System.out.println("ESCULL OPCIO:");
			int opcio = sc.nextInt();

			switch (opcio) {
			case 1:
				registrarRepartiment();
				break;
			case 2:
				int temps = veureTempsTotal();
				System.out.println("TEMPS TOTAL: " + temps);
				break;
			case 3:
				comptarRepartiments();
				break;
			case 4:
				int lent = mesLent();
				System.out.println("EL REPARTIMENT MES LENT HA DURAT " + lent + " MINUTS");
				break;
			case 5:
				int rapid = mesRapid();
				System.out.println("EL REPARTIMENT MES RAPID HA DURAT " + rapid + " MINUTS");

				break;
			case 6:
				tempsMitja();
				break;
			case 7:
				sortir = true;
				break;
			}
		}
	}

	static void tempsMitja() {

		int tempsTotal = veureTempsTotal();
		int numElements = repartiments.size();
		int tempsMitja = tempsTotal / numElements;

		System.out.println("EL TEMPS MITJA ES " + tempsMitja);
	}

	static int mesRapid() {
		int min = Collections.min(repartiments);
		return min;
	}

	static int mesLent() {
		int max = Collections.max(repartiments);
		return max;
	}

	static void comptarRepartiments() {
		System.out.println("AVUI S'HAN FET " + repartiments.size() + " REPARTIMENTS");
	}

	static int veureTempsTotal() {
		int acc = 0;
		for (int i = 0; i < repartiments.size(); i++) {
			acc = acc + repartiments.get(i);
		}
		return acc;
	}

	private static void registrarRepartiment() {
		System.out.println("DIGUES ELS MINUTS QUE HAS TRIGAT");
		int minuts = sc.nextInt();
		if (minuts > 0) {
			repartiments.add(minuts);
		}
	}

}