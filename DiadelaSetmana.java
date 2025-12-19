import java.util.Scanner;

public class DiadelaSetmana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int dia;
		dia = sc.nextInt();
		if (dia == 1) {
			System.out.println("Monday");
		}else if (dia == 2) {
			System.out.println("Tuesday");
		}else if (dia == 3) {
			System.out.println("Wednesday");
		}else if (dia == 4) {
			System.out.println("Thursday");
		}else if (dia == 5) {
		System.out.println("Friday");
		}else if (dia == 6) {
			System.out.println("Saturday");
		}else if (dia == 7) {
			System.out.println("Sunday");
		}
	}

}
