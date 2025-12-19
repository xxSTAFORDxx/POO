package Bucles;

import java.util.Scanner;

public class Númerospositius {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		int contador = 0;
		while (casos > 0) {
			int numero = sc.nextInt();
			if (numero >= 0) {
				contador++;
				casos--;
			}
		}
		System.out.println(contador);
	}
}