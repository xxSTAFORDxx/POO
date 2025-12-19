package Bucles;

import java.util.Scanner;

public class DiguesPatata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String caso;
		int casos = sc.nextInt();
		sc.nextLine();
		for (int i = casos; i != 0; i--) {
			caso = sc.nextLine();
			System.out.println(caso);
		}
	}
}