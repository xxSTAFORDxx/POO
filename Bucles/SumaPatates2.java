package Bucles;

import java.util.Scanner;

public class SumaPatates2 {

	public static void main(String[] args) { // TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		int camiones = 0;
		int patatas = 0;
		int acc = 0;
		for (int i = 0; i < casos; i++) {
			camiones = sc.nextInt();
			acc = 0;
			for (int a = 0; a < camiones; a++) {
				patatas = sc.nextInt();
				acc = acc + patatas;
			}
			System.out.println(acc);
		}
	}
}
