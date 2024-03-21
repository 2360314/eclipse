package d240317;

class Card{
	final int NUMBER;		// final 이 붙은 상수지만 선언과 함께 초기화 하지 않고
	final String KIND;		//  생성자에서 단 한번만 초기화 할 수 있다.
	static int width = 100;
	static int height = 250;
	
	Card(String kind, int num){
		KIND = kind;
		NUMBER = num;
	}
	
	Card(){
		this("HEART",1);
	}
	
	public String toString() {
		return KIND+" "+NUMBER;
	}
}
public class FinalCardTeest_7_12 {

	public static void main(String[] args) {
		Card c = new Card("HEART",10);
//		c.NUMBER = 5;
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c);

	}

}
