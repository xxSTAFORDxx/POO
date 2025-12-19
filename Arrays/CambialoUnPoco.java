package Arrays;

import java.util.Scanner;

public class CambialoUnPoco {

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
			int P1 = sc.nextInt();
			int P2 = sc.nextInt();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == P1) {
					arr[i] = P2;
				}
				System.out.print(arr[i]);
			}
		}
	}
}