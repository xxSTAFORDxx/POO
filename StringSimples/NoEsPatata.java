package StringSimples;

import java.util.Scanner;

public class NoEsPatata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < casos; i++) {
			String a = sc.nextLine();
			if (a.equalsIgnoreCase("patata")) {
				System.out.println("Es Patata");
			} else {
				System.out.println("No es Patata");
			}
		}
	}
}