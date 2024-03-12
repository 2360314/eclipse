package d240312;

abstract class Area{						// 도형 클래스 -> abstract 를 추가함으로써 추상 클래스라는걸 알려준다.
	public abstract void draw();			// 추상 메서드 생성함. 
}

class Rect extends Area{
	
	@Override								// 오버라이딩 했다고 알려주는거임
	public /* abstract */ void draw() {		// 오버라이딩. abstract는 지워야함.
		System.out.println("Rect");
	}
}

class Circle extends Area{
	
	@Override
	public void draw() {					// 오버라이딩. abstract는 지워야함.
		System.out.println("Circle");
	}
}

class Tri extends Area{
	
	@Override
	public void draw() {					// 오버라이딩. abstract는 지워야함.
		System.out.println("Tri");
	}
}

public class AbsClassExam {

	public static void main(String[] args) {
		Tri tri = new Tri();
		tri.draw();
		
		Rect rect = new Rect();
		rect.draw();
		
		Circle cir = new Circle();
		cir.draw();

	}

}
