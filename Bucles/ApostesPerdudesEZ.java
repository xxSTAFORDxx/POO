package Bucles;

import java.util.Scanner;

public class ApostesPerdudesEZ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int apostes;
		int contador = 0;
		for (apostes = 5; apostes != 0; apostes --) {
			int tirades = sc.nextInt();
			if (tirades < 0) {
				contador ++;}
		}
		System.out.println(contador);
	}
}