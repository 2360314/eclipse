package d240321;

import java.util.Scanner;

public class RecursiveExam2 {

	private int num;

	RecursiveExam2() {
		num = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RecursiveExam2 rs = new RecursiveExam2();
		System.out.println("Fibonacci n?");
		rs.num = sc.nextInt();
		
		for(int i=1; i>rs.num; i++) {
			System.out.print(rs.fibonacci(i)+" ");
		}
		
		System.out.println(rs.fibonacci(rs.num));
		
	

	}
	
	// 피보나치 함수로 받아오기
	public int fibonacci(int n) {
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else {
			return fibonacci(n - 2) + fibonacci(n - 1);
		}
	}
}
