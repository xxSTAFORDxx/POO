package Arrays;

import java.util.Scanner;

public class EscriuenUnArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[K];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLine();
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		int N = sc.nextInt();
		System.out.println(arr[N]);
	}
}