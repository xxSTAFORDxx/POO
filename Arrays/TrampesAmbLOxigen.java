package Arrays;

import java.util.Scanner;

public class TrampesAmbLOxigen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		for (int l = 0; l < casos; l++) {
			int K = sc.nextInt();
			int[] arr = new int[K];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int L = sc.nextInt();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < L) {
					arr[i] = arr[i]+ 1;
				}
				System.out.println(arr[i]);
			}
		}
	}
}