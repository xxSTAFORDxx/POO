package Bucles;

import java.util.Scanner;

public class MomentoBanana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos =sc.nextInt();
casos =sc.nextInt();
//
			while (casos !=0) {
			double vida=sc.nextInt();
			double daño=sc.nextInt();
			double vidarest;
			vidarest=vida%daño;
			if (vidarest<=1/5) {
				System.out.println("Momento Banana");
			}if (vidarest>1/5) {
				System.out.println("NOPE");
			}
		casos--;}
	}
}// 