package Bucles;

import java.util.Scanner;

public class RepartimentFitxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int P =1;
		for (int i= N; P<=10; P++) {
			int Total = N * P;
			System.out.println(N +" x " +P +" = " +Total );
		}
		
	}

	}
