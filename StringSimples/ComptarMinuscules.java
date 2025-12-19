package StringSimples;

import java.util.Scanner;

public class ComptarMinuscules {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < casos; i++) {
			String a = sc.nextLine();
			int contador = 0;
			for (int j = 0; j < a.length(); j++) {
				{
					contador++;

					System.out.println(contador);
				}
			}
		}
	}
}