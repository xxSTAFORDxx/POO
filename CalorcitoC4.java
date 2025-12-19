import java.util.Scanner;

public class CalorcitoC4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int alumnos;
		int temp;
		String mando;
		alumnos = sc.nextInt();
		temp = sc.nextInt();
		mando = sc.nextLine();
		if (alumnos > 15 || alumnos <= 30 && temp > 22 || temp <= 25 && mando == "NO") {
			System.out.println("Aire");
		} else if (alumnos > 15 || alumnos <= 30 && temp > 22 || temp <= 25 && mando == "SI") {
			System.out.println("Aire");
		} else if (alumnos > 15 || alumnos <= 30 && temp > 22 || temp <= 25 && mando == "NO") {
			System.out.println("Obrir Finestra");
		} else if (alumnos > 15 || alumnos <= 30 && temp > 22 || temp <= 25) {
		} else if (temp > 25 && mando == "SI") 
			System.out.println("Obrir Finestra");
	}
}


