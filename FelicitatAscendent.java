import java.util.Scanner;

public class FelicitatAscendent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int F1;
		int F2;
		int F3;
		F1 = sc.nextInt();
		F2 = sc.nextInt();
		F3 = sc.nextInt();
		if (F1 < F2 && F2 > F1 && F3> F2) {
			System.out.println("SI");
		}else {
			System.out.println("NO");
		}
	}

}