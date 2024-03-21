package d240321;

import java.util.Scanner;

public class RecursiveExam {

	private int num;

	RecursiveExam() {
		num = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RecursiveExam rs = new RecursiveExam();
		System.out.println("Factorial Number?");
		rs.num = sc.nextInt();

		rs.func1(rs.num);
		System.out.println(rs.factorial(rs.num));
		
	}

	// 1. 반복문으로 출력하기
	public void func1(int num) {
		int i;
		int fac = 1;
		for(i=1; i<=num; i++) {
			fac = fac*i;
		}
		System.out.println(fac);
	}

	// 2. 재귀함수로 출력하기
	public int factorial(int n) {

		if (n > 0) {
			return n * factorial(n-1);	
		}
		else
			return 1;

//		강사 정답
//		if(n==1) {
//			return 1;
//		}
//		return n*factorial(n-1);
	}
}