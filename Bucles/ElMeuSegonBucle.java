package Bucles;

import java.util.Scanner;

public class ElMeuSegonBucle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos =sc.nextInt();
		int barcos;
		int salvavidas;
		for (int i=0; i<casos; i++) {
			barcos=sc.nextInt();
			for (int j=0; j<barcos; j++) {
				salvavidas=sc.nextInt();
				salvavidas= salvavidas+1;
				System.out.println(salvavidas);
			}
		}
	}

}
