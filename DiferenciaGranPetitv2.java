import java.util.Scanner;

public class DiferenciaGranPetitv2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		int c;
		int result;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		if (a > b && a > c && b > c || c > b) {
			result = a - b;
			System.out.println(result);
		} else if (b > a && b > c && a > c || c > a) {
			result = b - a;
			System.out.println(result);
		} else if (c > a && c > b && a > b || b > a) {
			result = c - a;
			System.out.println(result);
		}
	}
}
