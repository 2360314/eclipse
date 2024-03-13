package d240313;

public class DefaultMethodTest {

	public static void main(String[] args) {
		Child c = new Child(); 	// Child 클래스 생성 및 객체 생성, 래퍼런스변수 c 생성
		c.method1(); 			// 이건 Child 안에 method1 이 들어가있기 때문에 그거 바로 가져옴
		c.method2();			// Child가 상속받는 Parent 에 있는 method2 를 가져옴
		MyInterface.staticMethod(); // MyInterface 안에 staticMethod 호출
		MyInterface2.staticMethod();
		
//		MyInterface.method1();	// 에러.
//		MyInterface.method2();	// 에러.
//		MyInterface2.method1();	// 에러.
		
		MyInterface m = new Child();
		m.method1();
	}
}

class Child extends Parent implements MyInterface, MyInterface2 {

	public void method1() {
		System.out.println("method1() in Child"); // 오버라이딩
	}
}

class Parent {
	public void method2() {
		System.out.println("method2() in Parent");
	}
}

interface MyInterface { // 안에 method 3개 (1, 2, static)
	default void method1() {
		System.out.println("method1() in MyInterface");
	}

	default void method2() {
		System.out.println("method2() in MyInterface");
	}

	static void staticMethod() {
		System.out.println("staticMethod() in MyInterface");
	}

}

interface MyInterface2 { // 안에 method 2개 (1, static)
	default void method1() {
		System.out.println("method1() in MyInterface2");
	}

	static void staticMethod() {
		System.out.println("staticMethod() in MyInterface");
	}

}
