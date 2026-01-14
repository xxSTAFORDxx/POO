package Llistes;

import java.util.ArrayList;
import java.util.Scanner;

public class PremiInesperat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		ArrayList<Integer> lista = new ArrayList<>();
		while (casos != 0) {
			lista.add(sc.nextInt());
		}
		int Carlota = sc.nextInt();
		int Joana = sc.nextInt();
		int CarlotaT = lista.get(Carlota);
		int JoanaT = lista.get(Joana);
		if (CarlotaT > JoanaT) {
			System.out.println("CARLOTA");
		} else {
			System.out.println("JOANA");
		}
	}
}