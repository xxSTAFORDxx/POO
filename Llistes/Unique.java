package Llistes;

import java.util.ArrayList;
import java.util.Scanner;

public class Unique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		for (int j = 0; j < casos; j++) {
			ArrayList<String> lista = new ArrayList<>();
			int k = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < k; i++) {
				String d = sc.nextLine();
				if (!lista.contains(d)) {
					lista.add(d);
				}
			}
			System.out.print(lista);
		}

	}
}