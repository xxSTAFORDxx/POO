package Bucles;

import java.util.Scanner;

public class DobleBucleMes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = i; j >= 1; j--) {
				System.out.println(j);
			}
		}
	}
}