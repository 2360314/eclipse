package d240310;

public class CallStackTest2 {

	public static void main(String[] args) {
		System.out.println("main 시작");
		firstMethod();
		System.out.println("main 종료");
	}
	static void firstMethod() {
		System.out.println("first 시작");
		secondMethod();
		System.out.println("first 종료");
	}
	
	static void secondMethod() {
		System.out.println("second 시작");
		System.out.println("second 종료");
	}
}
