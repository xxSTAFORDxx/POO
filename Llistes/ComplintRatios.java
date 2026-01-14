package Llistes;

import java.util.ArrayList;
import java.util.Scanner;

public class ComplintRatios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		for (int j = 0; j < casos; j++) {
			ArrayList<String> lista = new ArrayList<>();
			int K = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < K; i++) {
				lista.add(sc.next());
			}
			int P = sc.nextInt();
			lista.remove(P);
			for (int i = 0; i < lista.size(); i++) {
				System.out.print(lista.get(i) + " ");
			}
		}
	}
}