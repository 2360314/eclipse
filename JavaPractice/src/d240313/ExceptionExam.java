/*
 * 예외처리
 * - 결과가 중요한게 아니라 main 이 끝날 떄까지 돌리겠다.
 * - 정상적인 마무리를 수행하게 해주겠다.
 * - try ~ catch 문
 */
package d240313;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExceptionExam {

	public static void main(String[] args) throws ArithmeticException, InterruptedException{	// throws를 쓰면 예외 발생 시 해당 예외 클래스로 보내고, 계속 진행하는것으로
		
		Scanner sc = new Scanner(System.in);
		try {
		int num = sc.nextInt();
		
//		System.out.println(3/num);		// num에 0 입력하면 3/0 은 성립할 수 없어서 에러.
		// 예상되는 예외를 인식하기 위해 try 로 묶음
		
			System.out.println(3/num);
		} catch(ArithmeticException ae ) {	// ArithmeticException 는 num에 0 넣었을 때 나왔던 error class임.
			ae.printStackTrace();
			System.out.println("0으로 나누면 에러");
			
			return ;			// *-1 만약 0으로 나눈 에러가 발생해서 ArithmeticException 클래스를 불러오게 된다면, 여기에 return; 이 있으므로 여기서 종료된다.
			
		} catch(InputMismatchException in) {	// InputMismatchException 이라는 클래스에서 예외처리하지만, 이건 Exception 이라는 class 를 상속해.
			System.out.println("숫자를 입력하세요");
		}
		
		finally {
		System.out.println("Bye");		// *-2 여기에 있는 Bye 라는걸 무조건 출력하고 싶으면, 이처럼 finally 라는 블럭으로 묶어서 하면 이건 무조건 출력된다.
		}
	}

}
