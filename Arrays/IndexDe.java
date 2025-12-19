package Arrays;

import java.util.Scanner;

public class IndexDe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		for (int j = 0; j < casos; j++) {
			int K = sc.nextInt();
			int[] arr = new int[K];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int respuesta = -1;
			int FOLI = sc.nextInt();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == FOLI) {
					respuesta = i;
					break;
				}
			}
			System.out.println(respuesta);
		}
	}
}