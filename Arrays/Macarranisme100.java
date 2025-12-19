package Arrays;

import java.util.Scanner;

public class Macarranisme100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] arr = new double[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextDouble();
			System.out.println(arr[i]*100 +"%");
		}
	}
}