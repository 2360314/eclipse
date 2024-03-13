package d240313;

public class InnerExam01 {
	private int a;

	public void dispInter() {
		new AAA() { // anonymous inner class. 추상적인부분을 구체화하면 객체 생성이 가능해짐.
					// 1회성으로 생기고 없앨거라 래퍼런스 변수 만들 필요 없다.
			@Override // interface 안에 disp 라는 메서드를 여기서 구체화시킴
			public void disp() {
				System.out.println("anonymous :  "+a);	// outer class 의 field 는 맘대로 갖다쓸수있음"
						
			}
		}.disp();	// interface AAA를 갖다 쓴 AAA.disp(); 랑 같은 얘기다.
	}

	public static void main(String[] args) {
		InnerExam01 inter = new InnerExam01();
		
		inter.dispInter();		
		/* 돌아가는 순서 정리
		 * 1. class InnerExam01에 inter라는 래퍼런스 통해 접근
		 * 2. InnerExam01 안에 메서드 dispInter 접근
		 * 3. dispInter 안에 AAA라는게 있네? 같은 패키지 안에 AAA라는 이름의 클래스 혹은 인터페이스 찾음
		 * 4. 인터페이스 AAA 찾음. 근데 인터페이스 AAA는 추상화가 되어있음.
		 * 5. 그래서 dispInter 에서 추상화메서드 disp 를 구체화시키는 작업 돌림.
		 * 6. 추상화메서드 disp에 대해 어떤 기능 할건지 정의 하고, AAA.disp(); 로 마침 (14번라인 참고)
		 * 7. 끝났음. 출력.
		 */
		
	}

}
