package Llistes;

import java.util.ArrayList;
import java.util.Scanner;

public class EscriuenunArray3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> lista = new ArrayList<>();
		int n = sc.nextInt();
		while (n != -1) {
			lista.add(n);
			n = sc.nextInt();
		}
		System.out.println(lista);
		int k = sc.nextInt();
		System.out.println(lista.get(k));
	}
}