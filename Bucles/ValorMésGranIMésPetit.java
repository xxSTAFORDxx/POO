package Bucles;

import java.util.Scanner;

public class ValorMésGranIMésPetit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max = -100000;
		int min = 100000;
		int valor = sc.nextInt();
		while (valor != 0) {
			
			if (valor >= max) {
				max = valor;
			}
			if (valor <= min) {
				min = valor;
			}
			valor = sc.nextInt();
		}
		
		System.out.println(max + " " + min);
	}
}