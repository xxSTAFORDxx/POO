package Bucles;

import java.util.Scanner;

public class TiradesPerfectes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tirades = sc.nextInt();
		int contador = 0;
		while (tirades != -1) {
			if (tirades == 6) {
				contador++;
			}
			tirades = sc.nextInt();
		}
		System.out.println(contador);
	}
}