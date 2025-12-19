package Arrays;

import java.util.Scanner;

public class CercaAproximada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int l = 0; l < N; l++) {
			int K = sc.nextInt();
			int[] arr = new int[K];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int M = sc.nextInt();
			int contador = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == M || arr[i] == M - 1 || arr[i] == M + 1) {
					contador++;
				}
			}
			if (contador > 0) {
				System.out.println("SI");
			} else
				System.out.println("NO");
		}
	}
}