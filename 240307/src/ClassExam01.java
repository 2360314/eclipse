/*
 * 구성요소
 * 1. field  : 
 * 	- 객체가 생성된후 지속적으로 사용되어지는 변수
 *  - 접근지정자 주로 private.
 *  - static, final (읽기전용) 
 *  - instance field, static field 
 *    
 * 2. constructor(생성자함수) 
 *  - 객체 생성시 자동호출되어지는 함수 ( 딱 1번 _) 
 *  - 생성자함수를 명시적으로 제공하지 않을경우 디폴트생성자를 제공. 
 *  - 리턴타입이 존재하지않고, 함수명은 클래스명과 동일.
 *  - 기능 
 *     1) 디폴트기능 : 객체등록. 
 *     2) 사용자기능 : 객체생성시 필드초기화 
 *  - 오버로딩이 가능. 
 *  - 접근지정자를 주로 public으로 지정 .
 *  - 디폴트생성자를 명시적으로 만들경우 숨어있는 디폴트는 제공하지 않는다. 
 *  - 명시적으로 생성자를 하나이상 만들경우 디폴트는 제공하지 않는다. 
 * 
 * 3. method
 *  - 외부에서 내부의 필드를 접근해서 사용할수있게 하기위해.  
 *  - 접근지정자를 주로 public으로 지정 
 *  - instance method,static method 
 *    => this 여부. 
 *  - 오버로딩이 가능하다. ( 편의성 )   
 * 
 * 
 * 
 * 오버로딩.
 * 
 * - 동일한 함수명으로 여러개의 함수를 만들어서 제공 .
 * - 같은 기능을 수행하는 것을 하나의 이름으로 묶어서 제공함으로써 사용자가 편하게 쓸수있게 해주는 기능. 
 * - 함수명을 동일하게 하면서 (매개변수,인자,agument)를 구분을 할수있어야한다. 
 *    - 1. 매개변수 개수가 다를경우
 *    - 2. 매개변수 타입이 다를경우 
 */
public class ClassExam01 {

	private int a; 
	private char s; 	
	private float c; 
	
	
	public static void main(String[] args) {
		
		ClassExam01 ce = new ClassExam01();  // 생성자호출 
		ce.output(1,2);
		ce.output(3.4);
		ce.output(11);
		ce.output();

	}
	public void output(int a,int b) {
		System.out.println("a,b");
	}
	public void output(double a) {
		System.out.println("a");
	}
	public void output(int a) {
		System.out.println("int a");
	}
	
	public void output() {
		System.out.println("Nothing");
	}

}