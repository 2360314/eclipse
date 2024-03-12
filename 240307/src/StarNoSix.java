import java.util.Scanner;

public class StarNoSix {

	public static void main(String[] args) {

		String[][] star = new String[5][5];

		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력해주세요.");

		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int checkNum = Math.abs(i - num/2);

//System.out.println(checkNum);

			for (int j = 0; j < num; j++) {

				if (j < checkNum || num - checkNum <= j) {

					System.out.print(" ");

				} else {
					System.out.print("★");

				}
			}
			System.out.println();
		}
	}
}