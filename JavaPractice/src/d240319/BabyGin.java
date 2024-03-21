package d240319;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;

public class BabyGin {
	
	public static void main(String[] args) {
		BabyGin bg = new BabyGin();
		bg.BabyGin();
	}
	
	// BG 함수 
	public void BabyGin() {			
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int[] a = new int[6]; // 임의숫자 배열
		int[] arr = new int[10]; // 0~9까지 크기 배열
		int trip = 0;
		int run = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(10);                        //임의 숫자 6개
//			a[i] = sc.nextInt(); // 확인용 숫자입력칸
			System.out.print(a[i]);
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			arr[a[i]]++;                                  //임의숫자에 해당하는 배열값 증가
		}
		for (int i = 0; i < arr.length; i++) {             // 트리플 부분
			if (arr[i] >= 3) {                             //09배열에 증가시킨게 3개이상이면 임의숫자 배열에서 해당 숫자 3개 이상이라 초과면 트리플
				trip++;                                               
				arr[i] -= 3;                                // 트리플인 배열제거                  
				if (arr[i] >= 3) {                          //트리플 두번이 될수 있어서 추가적으로 3개이상이면 한번더 돌림
					trip++;
					arr[i] -= 3;
				}

			}

			if (i - 1 >= 0 && i + 1 < arr.length) {                        // run 부분
				if (arr[i - 1] > 0 && arr[i] > 0 && arr[i + 1] > 0) {        //연속된 배열에 값이 있으면 연속된 임의숫자 존재 
					arr[i - 1]--;                                          //run인 배열 부분들 제거
					arr[i]--;
					arr[i + 1]--;
					run++;
					if (arr[i - 1] > 0 && arr[i] > 0 && arr[i + 1] > 0) {        //run두개 있을 수 있어 한번 더
						arr[i - 1]--;
						arr[i]--;
						arr[i + 1]--;
						run++;
					}
				}
			}
		}
		System.out.println("Run : " + run);
		System.out.println("Triplete : " + trip);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				return;
		}
		System.out.println("Baby-gin~!");
	}
}
