package Arrays;

import java.util.Scanner;

public class EscriuenUnArray4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[] arr = new int[K];
		for (int i = 0; i < arr.length; i++) {

			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {

		}
		int N = sc.nextInt();
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + N);
	}
}