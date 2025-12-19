package Bucles;

import java.util.Scanner;

public class LaMevaCosina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		int acc = 0;
		int sueldo;
		for (int i = 0; i < casos; i++)
		{
			sueldo = sc.nextInt();
			if (sueldo >= 8000)
				acc = acc + sueldo;

		}
		System.out.println(acc);

	}

}
