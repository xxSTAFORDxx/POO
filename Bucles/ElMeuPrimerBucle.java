package Bucles;

import java.util.Scanner;

public class ElMeuPrimerBucle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		while (casos > 0) {
			int numero = sc.nextInt();
			casos--;
			System.out.println(numero + 1);
		}
	}
}