package Bucles;

import java.util.Scanner;

public class ApostesSenars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <=N; i++) {
			if( i%2==1)
			System.out.println(i);
		}

	}
}
