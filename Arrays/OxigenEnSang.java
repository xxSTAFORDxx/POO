package Arrays;

import java.util.Scanner;

public class OxigenEnSang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt();
		for (int j = 0; j < casos; j++) {
			int min = 100;
			int max = 0;
			int K = sc.nextInt();
			int[] arr = new int[K];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < min) {
					min = arr[i];
				}
				if (arr[i] > max) {
					max = arr[i];
				}
			}
			System.out.println(min);
			System.out.println(max);
		}
	}
}