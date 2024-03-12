package d240312;
/*
 *  extends: 상속 표현
 *  class는 단일상속만 된다.
 *  interface는 다중상속도 된다.
 *  
 *  오버라이딩( 다형성 )
 *  : 
 *  
 */



//
//public class IsAExam01 extends Object {	// IsAExam01 은 Object 클래스를 상속받는다. 기본으로 들어가기 때문에 생략가능
//
//	public String toString() {					// 오버라이딩 예시
//        return super.toString() + "Superman";	// super와 sub에 둘다 toString이 있는데요, 
//        										// toString 앞에 super 를 넣으면 superclass의 toString을 씀
//        										// 생략하면 무조건 현재 내(sub)의 toString을 갖다쓴다.
//        										// 즉, 오버라이딩은 super를 그대로 쓰는게 아니라 편집해서 쓰고싶을 때 씀.
//    }
//	
//	public static void main(String[] args) {
//		
//		IsAExam01 isa = new IsAExam01();	// 객체 생성. 디폴트생성자도 만들어짐.
//		System.out.println(isa);			// isa 호출
//		System.out.println(isa.toString()); // 이게 정석이지만, isa라는 래퍼런스변수를 부를 땐 toString()을 생략가능하다.
//		
//		isa.
//	}
//
//}
//class A{			// A 는 따로 쓰지 않아도 object를 상속받고있음
//	public String toString() {					
//        return super.toString() + "Superman";	 
//	}	
//	
//	public void disp() {
//		System.out.println("A Class");
//	}
//	
//}
//
//public class IsAExam01 extends A {	        									
//	
//	public static void main(String[] args) {
//												// 여기서 A를 상속받고있으므로, 여기에서 toStringㅇ르 쓰면 A걸 쓰는거다.
//		IsAExam01 isa = new IsAExam01();		// A에 없고 Object에 있는걸 쓴다면 자연히 Object거를 쓰는거다.
//		System.out.println(isa);				// 할아버지보다 부모가 상속 우선순위라는 뜻.
//		
//		isa.disp();
//	}

class A{	
	public A() {
		System.out.println("Super Class");
	}
}

public class IsAExam01 extends A {

	public IsAExam01() {
		// 이 위치에서 부모의 생성자를 호출했음 -> extends 한 A class의 생성자.
		// super();  <- 이 형태로. (부모의 디폴트생성자를 보겠다)
		System.out.println("Sub class");
	}
	
	public static void main(String[] args) {
		IsAExam01 isa = new IsAExam01();
	}
}


