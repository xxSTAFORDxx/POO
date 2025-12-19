package Bucles;

import java.util.Scanner;

public class ExplosionArcana1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int Ini = sc.nextInt();
		int Q = sc.nextInt();
		int acc = 0;
		for (int i = Q; Q != 0; Q--) {
			acc = acc + Ini * Q;
		}
		System.out.println(acc);}
}