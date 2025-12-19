package Bucles;

import java.util.Scanner;

public class ExplosionArcana2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int Ini = sc.nextInt();
		int HP = sc.nextInt();
		int acc = 0;
		int contador = 0;
		while (HP >= 0) {
			contador++;
			acc = HP;
			acc = acc - Ini;
			System.out.println(contador);
		}
	}
}