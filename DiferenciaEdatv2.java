import java.util.Scanner;

public class DiferenciaEdatv2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		int c;
		int d;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		if (a>b && a>c && b>c) {
			d = a - b;
			System.out.println(d);
		} else if (a > c) {
			d = a - c;
			System.out.println(d);
		} else if (b < c) {
			d = b - c;
			System.out.println(d);
		} else if (c > a) {
			d = c - a;
			System.out.println(d);
		} else if (c > b) {
			d = c - b;
			System.out.println(d);
		}
	}
}
