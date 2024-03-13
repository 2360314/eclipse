package d240313;

public class InnerClassExam01 {
	private int a;
	private static int b;

	public void dispTest() {
		class Test2 { // local inner class
			public void disp2() {
				System.out.println("local inner a:  "+a);
				System.out.println("local inner b:  "+b);
			}
		}
		Test2 test2 = new Test2();
		test2.disp2();
	}

	class Test { // member inner class
		public void disp() {
			System.out.println("member inner a:  "+a); // a, b는 InnerClassExam01 클래스 안에 Test클래스에 있으므로
			System.out.println("member inner b:  "+b); // a, b가 private 여도 쓸 수 있다.
		}
	}

	public static void main(String[] args) {
		InnerClassExam01 ic = new InnerClassExam01();
		InnerClassExam01.Test test = ic.new Test(); // 래퍼런스 test 자체를 InnerClassExam01 안에 Test로 접근하도록 만든다.

		// 위의 객체 2번 생성을 이렇게 축약할 수 있다.
		InnerClassExam01.Test newTest = new InnerClassExam01().new Test();

		test.disp();
		newTest.disp();

		// local inner class 사용
//		ic.dispTest.Test2 = ic.dispTest.new Test2();
		ic.dispTest();

	}

}
