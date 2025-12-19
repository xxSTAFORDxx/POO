package Arrays;

import java.util.Scanner;

public class TenRecordesDe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos =sc.nextInt();
		for (int i = 0; i < casos; i++) {
			int K = sc.nextInt();
			int[] arr = new int[K];
			for (int l = 0; l < arr.length; l++) {
				arr[l] = sc.nextInt();
			}
			for (int l = 0; l < arr.length; l++) {
			}
			int P = sc.nextInt();
			System.out.println(arr[P]);
		}
	}
}