import java.util.Scanner;

public class Eleccions2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int votsJiden = sc.nextInt();
		int votsDrump = sc.nextInt();
		if (votsJiden > votsDrump) {
			System.out.println("Jiden");
		} else {
			System.out.println("Drump");
		}
	}

}
