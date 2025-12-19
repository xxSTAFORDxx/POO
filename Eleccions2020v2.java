import java.util.Scanner;

public class Eleccions2020v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int Jiden = sc.nextInt();
		int Drump = sc.nextInt();
		if (Jiden > Drump) {
			System.out.println("Jiden");
		} else if (Jiden == Drump) {
			System.out.println("No");
		} else {
			System.out.println("Drump");
		}
	}
}