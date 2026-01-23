package Bucles;

import java.util.Scanner;

public class IntervalNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		if (num2 > num1) {
			System.out.println("El segon numero no es mes petit que el primer");
		} else {

			while (num1 >= num2) {
				System.out.println(num1--);

			}
		}
	}
}