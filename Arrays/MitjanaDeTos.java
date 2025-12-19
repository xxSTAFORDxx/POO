package Arrays;

import java.util.Scanner;

public class MitjanaDeTos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt();
		for (int j = 0; j < casos; j++) {
			int acc = 0;
			int K = sc.nextInt();
			int[] arr = new int[K];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < arr.length; i++) {
				acc = acc + arr[i] / K;
			}
			if (acc > 15) {
				System.out.println("A CASA");
			} else {
				System.out.println("A CLASSE");
			}
		}
	}
}
