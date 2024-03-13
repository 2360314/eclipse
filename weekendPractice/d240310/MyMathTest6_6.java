package d240310;

import java.util.Scanner;

public class MyMathTest6_6 {

	public static void main(String[] args) {
		MyMath mm = new MyMath();

		Scanner sc = new Scanner(System.in);
		System.out.println("첫 번째 수: ");
		int num1 = sc.nextInt();

		System.out.println("두 번째 수: ");
		int num2 = sc.nextInt();

		System.out.println("계산할 사칙연산?");
		char op = sc.next().charAt(0);

		double result = 0;

		switch (op) {
		case '+':
			result = mm.add(num1, num2);
			break;
		case '-':
			result = mm.sub(num1, num2);
			break;
		case '*':
			result = mm.mul(num1, num2);
			break;
		case '/':
			result = mm.div(num1, num2);
			break;
		}

		disp(num1, op, num2, result);
	}

	public static void disp(int num1, char op, int num2, double result) {
		System.out.println(num1 + "" + op + "" + num2 + " = " + result);
	}

}

class MyMath {
	int add(int a, int b) {
		return a + b;
	}

	int sub(int a, int b) {
		return a - b;
	}

	int mul(int a, int b) {
		return a * b;
	}

	double div(int a, int b) {
		return a / b;
	}

}
