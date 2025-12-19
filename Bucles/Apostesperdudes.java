package Bucles;

import java.util.Scanner;

public class Apostesperdudes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int apostes = sc.nextInt();
		int contador = 0;
		while (apostes != 0) {
			apostes = sc.nextInt();
			if (apostes < 0) {
				contador++;
			}
		}
		System.out.println(contador);
	}
}