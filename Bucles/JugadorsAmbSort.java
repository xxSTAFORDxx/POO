package Bucles;

import java.util.Scanner;

public class JugadorsAmbSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int apuestaMasGrande = 0;
		int apostes = sc.nextInt();
		while (apostes != 0) {
			if (apostes > apuestaMasGrande) {
				apuestaMasGrande = apostes;
			}

			apostes = sc.nextInt();
		}

		System.out.println(apuestaMasGrande);
	}
}