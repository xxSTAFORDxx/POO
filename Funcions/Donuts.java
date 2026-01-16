package Funcions;

import java.util.ArrayList;
import java.util.Scanner;

public class Donuts {

	static ArrayList<Integer> donuts = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("CONTROL DE DONUTS");

		boolean sortir = false;
		while (!sortir) {

			System.out.println("                  ");
			System.out.println("1. Registrar venda");
			System.out.println("2. Veure donuts total");
			System.out.println("3. Comptar vendes");
			System.out.println("4. Vendes mitjana");
			System.out.println("5. Vendes dotzenes");
			System.out.println("6. Vendes individuals");
			System.out.println("7. Vendes grans");
			System.out.println("8. Import total");
			System.out.println("9. Tinc diabetes?");
			System.out.println("10. Esborrar vendes");
			System.out.println("11. Sortir del programa");
			System.out.println("-----------");
			llistaNumerada();
			System.out.println("-----------");
			System.out.println("Escull una opcio:");
			int opcio = sc.nextInt();

			switch (opcio) {
			case 1:
				registrarVenda();
				break;
			case 2:
				int DonutsTotals = donutsTotals(); {
				System.out.println("Donuts totals venuts: " + DonutsTotals);
			}
				break;
			case 3:
				vendesTotals();
				break;
			case 4:
				donutsMitjana();
				break;
			case 5:
				donutsDotzena();
				break;
			case 6:
				donutsIndividual();
				break;
			case 7:
				donutsGrans();
				break;
			case 8:
				double importTotal = importTotal();
				System.out.println("El import total es de " + importTotal);
				break;
			case 9:
				diabetes();
				break;
			case 10:
				esborrarVendes();
				break;
			case 11:
				sortir = true;
				break;
			}
		}
	}

	public static void llistaNumerada() {
		int acc = 0;
		for (int i = 0; i < donuts.size(); i++) {
			acc++;
			System.out.println("Venda Numero " + acc + " : " + donuts.get(i) + " Donuts = "+ donuts.get(i)*0.50+"€");
		}
	}

	public static void registrarVenda() {
		System.out.println("Digues quants donuts has venut");
		{
			int DonutsVenduts = sc.nextInt();
			if (DonutsVenduts > 0) {
				donuts.add(DonutsVenduts);
			}

		}
	}

	public static int donutsTotals() {
		int accDonuts = 0;
		for (int i = 0; i < donuts.size(); i++) {
			accDonuts = accDonuts + donuts.get(i);
		}
		return accDonuts;
	}

	public static void vendesTotals() {
		System.out.println("El total de vendes es de " + donuts.size() + " donuts");
	}

	public static void donutsMitjana() {
		int DonutsVenduts = donutsTotals();
		int DonutsMitjana = DonutsVenduts / donuts.size();
		System.out.println("La mitjana de donuts es de " + DonutsMitjana);
	}

	public static void donutsDotzena() {
		int acc = 0;
		for (int i = 0; i < donuts.size(); i++) {
			if (donuts.get(i) == 12) {
				acc++;
			}
		}

		if (acc > 0) {
			System.out.println("S'han venut " + acc + "  Dotzenes de donuts");

		} else {
			System.out.println("No s'han venut cap dotzena de donuts");
		}
	}

	public static void donutsIndividual() {
		int acc = 0;
		for (int i = 0; i < donuts.size(); i++) {
			if (donuts.get(i) <= 5)
				acc++;
		}
		if (acc < 5) {
			System.out.println("S'han venut " + acc + "  packs de donuts individuals");
		} else {
			System.out.println("No s'han venut cap pack de donuts individuals");
		}
	}

	public static void donutsGrans() {
		int acc = 0;
		for (int i = 0; i < donuts.size(); i++) {
			if (donuts.get(i) >= 20) {
				acc++;
			}
		}

		if (acc > 0) {
			System.out.println("S'han venut " + acc + "  vegades mes de 20 donuts");

		} else {
			System.out.println("No s'han venut cap vegada mes de 20 donuts");
		}
	}

	public static double importTotal() {
		int DonutsTotals = donutsTotals();
		double Total = DonutsTotals * 0.50;
		return Total;
	}

	public static void diabetes() {
		int acc = 0;
		for (int i = 0; i < donuts.size(); i++) {
			if (donuts.get(i) >= 100)
				acc++;
		}

		if (acc > 0)

		{
			System.out.println("PELIGRO!! Hay un diabetico suelto!!");

		} else {
			System.out.println("Sergio I el Hater se prepara para comprar mas DONUTS!!");
		}
	}

	public static void esborrarVendes() {
		sc.nextLine();
		System.out.println("Vols esborrar totes les vendes?");
		System.out.println("Si / No");
		String reposta = sc.nextLine();
		if (reposta.equals("Si")) {
			donuts.clear();
			System.out.println("Vendes esborrades");
		}

	}
}
