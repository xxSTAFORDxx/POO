package Bucles;

import java.util.Scanner;

public class Nota10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int notas = 0;
		int contador = 0;
		int contador10 = 0;
		while (notas != -1) {
			notas = sc.nextInt();
			if (notas == 10) {
				contador10++;
			} 
			if (notas >= 0 && notas <= 10) {
				contador++;
			}
		}
		System.out.println("TOTAL NOTES: " + contador + " NOTES10: " + contador10);
	}
}