/*
 * this :  자기자신을 접근 하는 객체레퍼런스변수.
 *         인스턴스 메소드의 첫번째 매개변수로 항상 존재.
 *         선언할수는 없고 사용만 가능
 *         객체 구별해주는 역활 => 디폴트기능 
 *         
 *         1. 필드명과 지역변수이름이 같을경우 필드를 구별하기 위해 
 *         2. 인스턴스메소드에서 자기자신의 객체를 리턴하고 싶을때. 
 * 
 * 
 * this() 
 * - 자기자신의 또다른 생성자를 호출 
 * 
 */
public class ThisExam01 {

	int a;
	
	public int getA() {
		return this.a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public ThisExam01 getObject() {
		return this; 
	}
	
	

	public static void main(String []ar) {
		ThisExam01 th = new ThisExam01();
		
		th.setA(100);
		
		ThisExam01 th2 = th.getObject();
		
		System.out.println(th);
		System.out.println(th2);
	}
	
}


