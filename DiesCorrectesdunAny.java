import java.util.Scanner;

public class DiesCorrectesdunAny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numero;
		numero = sc.nextInt();
		if (numero == 366) {
			System.out.println("Correcte per un any bixest!");
		} else if (numero >= 1 && numero <= 365) {
			System.out.println("Correcte per un any no bixest!");
		} else {
			System.out.println("Incorrecte!");
		}
	}
}