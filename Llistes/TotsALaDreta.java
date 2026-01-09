package Llistes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TotsALaDreta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> lista = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			lista.add(sc.nextInt());
		}
		Collections.rotate(lista, 1);
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i) + " ");
		}
	}
}