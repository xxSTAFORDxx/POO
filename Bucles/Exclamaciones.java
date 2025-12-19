package Bucles;

import java.util.Scanner;

public class Exclamaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while (str != "FIN") {
			if (str) {

				System.out.println("SI");
			} else {
				System.out.println("NO");
			}
		}
		str = sc.nextLine();
	}
}
