package Bucles;

import java.util.Scanner;

public class ComptadorDeFitxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int fitxa = sc.nextInt();
		int contador = 1;
		while (fitxa >= contador) {
			System.out.println(contador);	
			contador ++;
		}

	}
}
