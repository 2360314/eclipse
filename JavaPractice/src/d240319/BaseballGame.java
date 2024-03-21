package d240319;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
	
	public static void main(String[] args) {
		Random random = new Random();

		int[] com; // 컴퓨터 랜덤 생성
		int[] p1; // 사용자 입력 값
		int[] num;
		int strike = 0;
		int ball = 0;
		float total = 0;
		int count = 0;
		int set = 0;

		com = new int[3];
		p1 = new int[3];
		num = new int[10];
		char cont = 'a';
		Scanner sc = new Scanner(System.in);
		System.out.println("Game Start");

		do {
			++set;
			// com 에 랜덤 3자리 숫자 생성
			for (int i = 0; i < com.length; i++) {
				com[i] = random.nextInt(10);
				for (int j = 0; j < i; j++) {
					if (com[i] == com[j]) {
						i--;
					}
				}
			}

			// com 값 화면에 보여주기
			for (int c = 0; c < 3; c++) {
				System.out.print(com[c]);
			}
			System.out.println("세자리 숫자를 입력하세요");

			while (true) {
				String tmp = sc.next();
				for (int i = 0; i < 3; i++) {
					p1[i] = tmp.charAt(i) - '0';
				}
				strike = 0;
				ball = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (p1[i] == com[j]) {
							if (i == j) {
								strike++;
							} else {
								ball++;
							}
						}
					}
				}
				if (strike == 0 && ball == 0) {
					System.out.println("Out");
				} else {
					System.out.println(strike + "  Strike\t" + ball + "  ball");
				}

				count++;

				if (strike == 3) {
					System.out.println("정답");
					total += count;
					System.out.println("입력횟수 :\t" + count);
					System.out.println("set: " + set);

					count = 0;
					break;
				}
			}

			System.out.println("평균" + total / set + " 회 만에 정답");
			System.out.println("continue? (Y,N)");
			cont = sc.next().charAt(0);
		} while (cont == 'y' || cont == 'Y');
	}
}
