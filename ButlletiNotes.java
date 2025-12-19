import java.util.Scanner;

public class ButlletiNotes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int notes;
		notes = sc.nextInt();
		if (notes >= 0 && notes <= 4) {
			System.out.println("Suspes");
		} else if (notes >= 5 && notes <= 6) {
			System.out.println("Aprovat");
		} else if (notes >= 7 && notes <= 8) {
			System.out.println("Notable");
		} else if (notes >=9 && notes <=10)
			System.out.println("Excelent");
		
	}
}
