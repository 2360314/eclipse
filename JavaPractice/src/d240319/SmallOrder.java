package d240319;

import java.util.Scanner;

public class SmallOrder {

	public static void main(String[] args) {

		int[] num = new int[4];

		for (int a = 1000; a < 10000; a++) {
			int number = a;
			for (int b = 0; b < 4; b++) {
				num[b] = number % 10;
				number /= 10;
			}
			for(int c = 0; c < 4; c++) {
				System.out.print(num[c]);
			}
			
			int temp = 0;
			while (true) {
				for (int i = 0; i < num.length - 1; i++) {

					if (num[i] > num[i + 1]) {
						int tmp = 0;
						tmp = num[i];
						num[i] = num[i + 1];
						num[i + 1] = tmp;
						temp++;
					}
				}
				if (temp == 0) {
					break;
				}
				temp = 0;
			}

			if (num[0] == 0) {
				for (int i = 1; i < 4; i++) {
					if (num[i] != 0) {
						int temp2 = 0;
						temp2 = num[i];
						num[i] = num[0];
						num[0] = temp2;
						break;
					}
				}
			}
			System.out.print(" ");
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i]);
			}

			System.out.println();
		}

	}

}
