package Bucles;

import java.util.Scanner;

public class HarrisonFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int millon = sc.nextInt();
		if (millon >= 1000000) {
			for (int i = 0; i < millon;) {
				i = i + 1000000;
				System.out.println(i);
			}
		}
	}

}
