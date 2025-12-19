package Arrays;

import java.util.Scanner;

public class ComptarEnArrays0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[] arr = new int[K];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int P = sc.nextInt();
		int contador = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == P) {
				contador++;
			}
		}
		System.out.println(contador);
	}
}