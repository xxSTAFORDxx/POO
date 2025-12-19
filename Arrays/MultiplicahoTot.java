package Arrays;

import java.util.Scanner;

public class MultiplicahoTot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		for (int i = 0; i < casos; i++) {
			int K = sc.nextInt();
			int[] arr = new int[K];
			for (int l = 0; l < arr.length; l++) {
				arr[l] = sc.nextInt();
			}
			int P = sc.nextInt();
			int contador = 0;
			for (int l = 0; l < arr.length; l++) {
				if (arr[l] == P) {
					contador++;
				}
				System.out.println(arr[l] * P);
			}
		}
	}
}