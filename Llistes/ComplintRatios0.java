package Llistes;

import java.util.ArrayList;
import java.util.Scanner;

public class ComplintRatios0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> lista = new ArrayList<>();
		int k = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < k; i++) {
			lista.add(sc.next());
		}
		int p = sc.nextInt();
		lista.remove(p);
		for (int i = 0; i < lista.size(); i++) {
		}
		System.out.print(lista + " ");
	}
}