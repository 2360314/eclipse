package d240313;
import java.util.Scanner;

public class JavaExceptionPractice {
	
	
	public static void main(String[] args) {
		
//		int[] arr = new int[5];		// 5짜리 int 배열 arr 선언 및 초기화
//		try {
//		arr[6] = 20;				// arr 에 없는 6번째 자리에 값 대입
//		} catch(ArrayIndexOutOfBoundsException ai) {
//			System.out.println("배열의 범위를 벗어남");
//		}
		
		Scanner sc = new Scanner(System.in);
		try {
		int a = sc.nextInt();
		System.out.println(3/a);		// 3을 입력받은 값으로 나누는 값 출력
		}
		catch(ArithmeticException ae) {
			System.out.println("숫자입력오류");	// 0으로 나누면 Arithmetic예외로 숫자입력오류 출력
		}
	}
}
