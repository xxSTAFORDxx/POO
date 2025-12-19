package Bucles;

import java.util.Scanner;

public class ElMeuPrimerBucleWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		while (casos != 0) {
			System.out.println(casos + 1);
			casos = sc.nextInt();
		}
	}
}