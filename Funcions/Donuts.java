package Funcions;

import java.util.ArrayList;
import java.util.Scanner;

public class Donuts {

	static ArrayList<Integer> repartiments = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("CONTROL DE DONUTS");

		boolean sortir = false;
		while (!sortir) {

			System.out.println(Donuts);
			System.out.println("1. REGISTRAR VENDA");
			System.out.println("2. VEURE DONUTS TOTAL");
			System.out.println("3. COMPTAR VENDES");
			System.out.println("4. VENDES MITJANA");
			System.out.println("5. VENDES DOTZENES");
			System.out.println("6. VENDES INDIVIDUALS");
			System.out.println("7. ESBORRAR VENDES");
			System.out.println("8. SORTIR DEL PROGRAMA");
			System.out.println("-----------");
			System.out.println("ESCULL OPCIO:");
			int opcio = sc.nextInt();

			switch (opcio) {
			case 1:
				registrarVenda();
				break;
			case 2:
				int donutsT = donutsTotals();
				System.out.println("DONUTS TOTAL VENUTS: " + donutsT);
				break;
			case 3:
				int vendesT = vendesTotals();
				System.out.println("EL TOTAL DE VENDES ES DE " + vendesT);
				break;
			case 4:
				int donutsM = donutsMitjana();
				System.out.println("LA MITJANA DE DONUTS VENUTS ES DE " + donutsM);
				break;
			case 5:
				int donutsD = donutsDotzena();
				System.out.println("S'HAN VENUT" + donutsD + "  DOTZENES DE DONUTS"); // PONER EN LA FUNCION
				break;
			case 6:
				int donutsI = donutsIndividual();
				System.out.println("S'HAN VENUT " + donutsI + "DONUTS INDIVIDUALS"); // PONER EN LA FUNCION
				break;
			case 7:
				sortir = true;
				break;
			}

	public static void registrarVenda() {
		int accDonuts = 0;
		System.out.println("DIGUES QUANTS DONUTS HAS VENUT");
	}

	public static void donutsTotals() {
		int accDonuts = 0;
	}

	public static void vendesTotals() {
	}

	public static void donutsMitjana() {
	}

	public static void donutsDotzena() {
	}

	public static void donutsIndividual() {
	}
}
