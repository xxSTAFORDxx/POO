package Concurso;

import java.util.Scanner;

public class ElCamiMesCurt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String casos = sc.nextLine();
		int posicionizq = 0;
		int posiciondrch = 0;
		while (!casos.equals("END")) {
			String letra = sc.nextLine();
			posicionizq = casos.indexOf(letra);
			posiciondrch = casos.lastIndexOf(letra);
			if (posicionizq > casos.length() - posiciondrch - 1) {
				System.out.println(posiciondrch + " " + "<-");
			} else if (posicionizq < casos.length() - posiciondrch - 1) {
				System.out.println(posicionizq + " " + "->");
			} else if (posicionizq == casos.length() - posiciondrch - 1)
				System.out.println(posicionizq + " " + "==");
			casos = sc.nextLine();
		}
	}
}