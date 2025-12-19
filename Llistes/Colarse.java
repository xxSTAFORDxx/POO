package Llistes;

import java.util.ArrayList;
import java.util.Scanner;

public class Colarse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		for (int j = 0; j < casos; j++) {
			ArrayList<Integer> lista = new ArrayList<>();
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				lista.add(sc.nextInt());
			}
			int C = sc.nextInt();
			int P = sc.nextInt();
			lista.add(P, C);
			for (int i=0; i<lista.size(); i++) {
			System.out.print(lista.get(i) +" ");
			}
		}
	}
}