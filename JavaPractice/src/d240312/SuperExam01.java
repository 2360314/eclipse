package d240312;

class AA{
	private int a;		// 10

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	public AA() {
		super();
	}
	public AA(int a) {
		this.a = a;
	}
	
}

class BB extends AA{
	private int b;		// 20

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public BB() {
		
	}
	public BB(int a, int b) {
		super(a);
		this.b = b;
	}
}

class CC extends BB{
	private int c;

	public int getC() {
		return c;
	}
	

	public void setC(int c) {
		this.c = c;
	}
	
	public CC() {		
		super();
	}
		
	public CC(int a, int b, int c) {	// 생성자 오버로딩
		super(a, b);
		this.c = c;
	}
}




public class SuperExam01 {

	public static void main(String[] args) {
		CC cc = new CC(10, 20, 30);		// a= 10, b= 20, c= 30 을 넣고싶다.
		
//		cc.a = 10;		// CC -> BB -> AA 까지 상속받기 때문에 CC는 a 도 쓸 수 있다.
		
		System.out.println(cc.getA());
		System.out.println(cc.getB());
		System.out.println(cc.getC());
	}

}
