import java.util.Scanner;

public class PedraPaperTisores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		//System.out.println("Tria un: 1 es pedra, 2 és paper i 3 és tisora");
		a = sc.nextInt();
		//System.out.println("Tria un: 1 es pedra, 2 és paper i 3 és tisora");
		b = sc.nextInt();
		if (a== 1 && b==3 || a== 2 && b==1 || a== 3 && b==2) {
			System.out.println("Jugador1");
		} else if (b== 1 && a==3 || b== 2 && a==1 || b== 3 && a==2)  {
			System.out.println("Jugador2");
		}else if (a==1 && b== 1 || a==2 && b == 2 || a==3 && b== 3) {
			System.out.println("EMPAT");
		} else {
			System.out.println("ERROR");
			{
			}
		}
	}
}