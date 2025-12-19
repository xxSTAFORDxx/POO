import java.util.Scanner;

public class DiferenciaGranPetit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int firstNum;
		int secondNum;
		int Res;
		firstNum = sc.nextInt();
		secondNum = sc.nextInt();
		if (firstNum > secondNum) {
			Res = firstNum - secondNum;
			System.out.println(Res);
		} else {
			Res = secondNum - firstNum;
			System.out.println(Res);
		}

	}
}