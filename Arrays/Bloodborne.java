package Arrays;

import java.util.Scanner;

public class Bloodborne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int j = 0; j < N; j++) {
			int contador = 0;
			int K = sc.nextInt();
			int[] arr = new int[K];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] == arr[i + 1]) {
					contador++;
				}
			}
			if (contador >= 1) {
				System.out.println("SI");
			} else if (contador <= 0) {
				System.out.println("NO");
			}
		}
	}
}